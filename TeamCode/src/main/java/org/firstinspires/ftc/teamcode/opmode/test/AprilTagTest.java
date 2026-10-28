package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.robot.WebcamOnly;

@TeleOp(name = "AprilTagTest")
public class AprilTagTest extends LinearOpMode {
    WebcamOnly robot;

    @Override
    public void runOpMode() {
        robot = WebcamOnly.build(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            robot.webcamTelemetry();
        }
    }
}