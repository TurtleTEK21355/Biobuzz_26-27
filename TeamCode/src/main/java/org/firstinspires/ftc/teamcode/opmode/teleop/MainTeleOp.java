package org.firstinspires.ftc.teamcode.opmode.teleop;

//import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.libcode.examples.command.SimultaneousAllCommand;
import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.libcode.library.commandsinternal.CommandScheduler;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.command.FlywheelSetVelocity;
import org.firstinspires.ftc.teamcode.command.GatesOpen;
import org.firstinspires.ftc.teamcode.robot.Sting;

//@Configurable
@TeleOp(name = "TeleOp", group = "teleop")
public class MainTeleOp extends OpMode {
    protected Sting robot;
    private final CommandScheduler commandScheduler = new CommandScheduler();



    @Override
    public void init() {
        TelemetryPasser.telemetry = telemetry;
        robot = Sting.build(hardwareMap);

        telemetry.addLine("Controls here:");
        telemetry.addLine("\nDrivetrain: Joysticks");
        telemetry.addLine("Intake: Left Bumper");
        telemetry.addLine("Shoot: Right Bumper");
        telemetry.update();
    }

    @Override
    public void loop() {
        telemetry.addData("Position (Pinpoint)", robot.getPinpoint().getPosition());
        telemetry.addLine("\nFlywheel Velocities:");
        telemetry.addData("Pollen:", robot.getFlywheelPollen().getVelocity());
        telemetry.addData("Nectar:", robot.getFlywheelNectar().getVelocity());


        robot.getDrivetrain().control(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

//        if (gamepad1.left_bumper) robot.getIntake().setPower(0.8);
//        else robot.getIntake().setPower(0);
//
//        if (gamepad1.right_bumper) {
//            robot.getFlywheelNectar().setVelocity(300);
//            robot.getFlywheelPollen().setVelocity(300);
//            if (robot.getFlywheelNectar().getVelocity()>280 && robot.getFlywheelPollen().getVelocity()>280)
//                robot.getGates().open();
//        } else {
//            robot.getFlywheelNectar().setVelocity(0);
//            robot.getFlywheelPollen().setVelocity(0);
//            robot.getGates().close();
//        }
//        robot.getAugur().setPower(gamepad1.left_trigger/2.5);
//
//        telemetry.update();
    }
}
