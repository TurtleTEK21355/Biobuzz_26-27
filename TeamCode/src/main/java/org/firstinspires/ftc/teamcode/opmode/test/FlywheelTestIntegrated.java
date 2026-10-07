package org.firstinspires.ftc.teamcode.opmode.test;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.bylazar.gamepad.PanelsGamepad;
import com.bylazar.telemetry.PanelsTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.Prototype;

@TeleOp(name = "Flywheel Test")
public class FlywheelTestIntegrated extends LinearOpMode {
    Prototype robot;

    @Override
    public void runOpMode() {
        PanelsGamepad virtualGamepad = PanelsGamepad.INSTANCE;
        telemetry = new MultipleTelemetry(telemetry, PanelsTelemetry.INSTANCE.getFtcTelemetry());
        TelemetryPasser.telemetry = telemetry;

        robot = Prototype.build(hardwareMap);
        telemetry.update();

        double velocityPollen = 0;
        double velocityNectar = 0;
        waitForStart();
        while(opModeIsActive()) {
            Gamepad gamepad1 = virtualGamepad.getFirstManager().asCombinedFTCGamepad(super.gamepad1);
            Gamepad gamepad2 = virtualGamepad.getFirstManager().asCombinedFTCGamepad(super.gamepad2);

            robot.getDrivetrain().control(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad2.left_stick_x);

            robot.setIntakePower(gamepad1.left_trigger);

            if (gamepad1.dpadDownWasPressed()) {velocityNectar -= 10;}
            if (gamepad1.dpadUpWasPressed()) {velocityNectar += 10;}
            if (gamepad1.dpadLeftWasPressed()) {velocityNectar -= 200;}
            if (gamepad1.dpadRightWasPressed()) {velocityNectar += 200;}

            if (gamepad1.aWasPressed()) {velocityPollen -= 10;}
            if (gamepad1.yWasPressed()) {velocityPollen += 10;}
            if (gamepad1.bWasPressed()) {velocityPollen -= 200;}
            if (gamepad1.xWasPressed()) {velocityPollen += 200;}

            robot.setFlywheelNectarVelocity(velocityNectar);
            robot.setFlywheelPollenVelocity(velocityPollen);
            robot.flywheelsTelemetry();

            telemetry.update();
        }
    }
}