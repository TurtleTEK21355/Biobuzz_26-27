package org.firstinspires.ftc.libcode.examples.command;

import org.firstinspires.ftc.libcode.examples.robot.Constants;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.internal.pid.PIDControllerHeading;
import org.firstinspires.ftc.libcode.library.internal.pid.PIDControllerSpeedLimit;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryString;
import org.firstinspires.ftc.libcode.library.sensor.localization.Localizer;
import org.firstinspires.ftc.libcode.library.sensor.localization.OTOSSensor;

public class MovePIDCommand extends Command {
    private Pose2D position;
    double speed;
    MechanumDrive drivetrain;
    Localizer localizer;
    PIDControllerSpeedLimit yPID;
    PIDControllerSpeedLimit xPID;
    PIDControllerHeading hPID;

    public String dataKey = "MovePIDCommand";


    /**
     * Regular general-purpose move PID
     * @param target Target position for movement
     * @param speed Maximum PID speed
     * @param drivetrain
     * @param localizer
     */
    public MovePIDCommand(Pose2D target, double speed, MechanumDrive drivetrain, Localizer localizer) {
        this.drivetrain = drivetrain;
        this.localizer = localizer;
        this.speed = speed;
        yPID = new PIDControllerSpeedLimit(Constants.getLinearPIDConstants(), target.y, Constants.getPIDTolerance().y, speed);
        xPID = new PIDControllerSpeedLimit(Constants.getLinearPIDConstants(), target.x, Constants.getPIDTolerance().x, speed);
        hPID = new PIDControllerHeading(Constants.getAngularPIDConstants(), target.h, Constants.getPIDTolerance().h, speed);
    }

    @Override
    public void loop() {
        position = localizer.getPosition();
        double xCalc = xPID.calculate(position.x);
        double hCalc = hPID.calculate(position.h);
        double yCalc = yPID.calculate(position.y);
        drivetrain.fcControl(yCalc, xCalc, hCalc, position.h);

    }

    @Override
    public String telemetry() {
        TelemetryString string = new TelemetryString();

        string.addData("yPID at Position ", yPID.atTarget(position.y));
        string.addData("xPID at Position ", xPID.atTarget(position.x));
        string.addData("hPID at Position ", hPID.atTarget(position.h));
        string.addData("Robot Position ", position);

        return string.toString();
    }

    @Override
    public boolean isCompleted() {
        return (yPID.atTarget(position.y) && xPID.atTarget(position.x) && hPID.atTarget(position.h));
    }

}