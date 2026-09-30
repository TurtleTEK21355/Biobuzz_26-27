package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TwoFlywheelTester", group="Linear OpMode")

public class TwoFlywheelTester extends LinearOpMode {
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;

    private DcMotor intake = null;
    private DcMotorEx shooter1 = null;

    private DcMotorEx shooter2 = null;
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");
        intake = hardwareMap.get(DcMotor.class, "intake");

        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);
        shooter1 = hardwareMap.get(DcMotorEx.class, "shooter1");
        shooter2 = hardwareMap.get(DcMotorEx.class, "shooter2");
        double shooterPower1 = 0;
        double shooterPower2 = 0;
        waitForStart();
        while (opModeIsActive()) {
            double intakePower = gamepad1.left_trigger;
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x;
            double h = -gamepad1.right_stick_x;
            double shooterPowerInRPM1 = shooterPower1 * (60/28);
            double shooterPowerInRPM2 = shooterPower2 * (60/28);
            fr.setPower(Range.clip(y - x - h, -1, 1));
            fl.setPower(Range.clip(y + x + h, -1, 1));
            br.setPower(Range.clip(y + x - h, -1, 1));
            bl.setPower(Range.clip(y - x + h, -1, 1));

            intake.setPower(intakePower);
            shooter1.setVelocity(shooterPower1);
            shooter2.setVelocity(shooterPower2);
            telemetry.addData("Motor 1 Shooter Power:",60/28*shooter1.getVelocity());
            telemetry.addData("Goal Velocity:", shooterPowerInRPM1);
            telemetry.addData("SP in Ticks", shooter1.getVelocity());
            telemetry.addData("Motor 2 Shooter Power:",60/28*shooter2.getVelocity());
            telemetry.addData("Goal Velocity:", shooterPowerInRPM2);
            telemetry.addData("SP in Ticks", shooter2.getVelocity());
            telemetry.update();

            if (gamepad1.bWasPressed()) {
                shooterPower1 += 10;
            }
            if (gamepad1.xWasPressed()) {
                shooterPower1 -= 10;
            }

            if (gamepad1.yWasPressed()) {
                shooterPower1 += 100;
            }
            if (gamepad1.aWasPressed()) {
                shooterPower1 -= 100;
            }

            if (gamepad1.dpadRightWasPressed()) {
                shooterPower2 += 10;
            }
            if (gamepad1.dpadLeftWasPressed()) {
                shooterPower2 -= 10;
            }

            if (gamepad1.dpadUpWasPressed()) {
                shooterPower2 += 100;
            }
            if (gamepad1.dpadDownWasPressed()) {
                shooterPower2 -= 100;
            }
        }

    }
}
