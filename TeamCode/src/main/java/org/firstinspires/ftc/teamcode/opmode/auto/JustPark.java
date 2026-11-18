package org.firstinspires.ftc.teamcode.opmode.auto;

//import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.*;
import org.firstinspires.ftc.libcode.library.commandsinternal.LinearCommandOpMode;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.Sting;

//@Configurable
@Autonomous(name= "Leave N' Park", group = "auto")
public class JustPark extends LinearCommandOpMode {
    //Robot Start

    Sting robot;
    Pose2D tolerance = new Pose2D(1.5,1.5,5);

    @Override
    public void initialize() {
        TelemetryPasser.telemetry = telemetry;
        robot = Sting.build(hardwareMap);
        sleep(500);
        robot.getPinpoint().setPosition(new Pose2D(9, 84, -90));
        sleep(300);
        robot.getPinpoint().positionTelemetry();
        telemetry.update();
        commands();
    }

    public void commands () {
        addCommand(new MovePIDCommand(new Pose2D(13, 90,-90), 0.75, robot.getDrivetrain(), robot.getPinpoint(), tolerance));
    }

    @Override
    public void runOpMode() {
        super.runOpMode();
    }

    @Override
    public void cleanup() {

    }
}
