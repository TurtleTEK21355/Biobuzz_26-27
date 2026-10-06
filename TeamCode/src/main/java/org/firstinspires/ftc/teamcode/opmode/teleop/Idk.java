package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.bylazar.gamepad.PanelsGamepad;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.FlywheelPrototype;

@TeleOp(name = "Flywheel Test")
public class Idk extends LinearOpMode {
    FlywheelPrototype robot;

    @Override
    public void runOpMode() {
        PanelsGamepad virtualGamepad = PanelsGamepad.INSTANCE;
        telemetry = new MultipleTelemetry(telemetry, PanelsTelemetry.INSTANCE.getFtcTelemetry());
        TelemetryPasser.telemetry = telemetry;

        robot = FlywheelPrototype.build(hardwareMap);
        telemetry.update();

        double velocityLeft = 0;
        double velocityRight = 0;
        waitForStart();
        while(opModeIsActive()) {
            Gamepad gamepad1 = virtualGamepad.getFirstManager().asCombinedFTCGamepad(super.gamepad1);
            Gamepad gamepad2 = virtualGamepad.getFirstManager().asCombinedFTCGamepad(super.gamepad2);

            if (gamepad1.dpadDownWasPressed()) {velocityRight -= 10;}
            if (gamepad1.dpadUpWasPressed()) {velocityRight += 10;}
            if (gamepad1.dpadLeftWasPressed()) {velocityRight -= 200;}
            if (gamepad1.dpadRightWasPressed()) {velocityRight += 200;}

            if (gamepad1.aWasPressed()) {velocityRight -= 10;}
            if (gamepad1.yWasPressed()) {velocityRight += 10;}
            if (gamepad1.bWasPressed()) {velocityRight -= 200;}
            if (gamepad1.xWasPressed()) {velocityRight += 200;}

            robot.setFlywheelLeftVelocity(velocityLeft);
            robot.setFlywheelRightVelocity(velocityRight);

            robot.flywheelsTelemetry();
            telemetry.update();
        }
    }
}