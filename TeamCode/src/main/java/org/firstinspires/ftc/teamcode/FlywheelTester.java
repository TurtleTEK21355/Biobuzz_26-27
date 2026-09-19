package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="FlywheelTester", group="Linear OpMode")
public class FlywheelTester extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor fl = null;
    private DcMotor bl = null;
    private DcMotor fr = null;
    private DcMotor br = null;
    private DcMotorEx shooter = null;
    public void runOpMode() {
        fl = hardwareMap.get(DcMotor.class, "fl");
        bl = hardwareMap.get(DcMotor.class, "bl");
        fr = hardwareMap.get(DcMotor.class, "fr");
        br = hardwareMap.get(DcMotor.class, "br");

        fr.setDirection(DcMotorSimple.Direction.REVERSE);
        br.setDirection(DcMotorSimple.Direction.REVERSE);
        shooter = hardwareMap.get(DcMotorEx.class, "shooter");
        double shooterPower = 0;
        waitForStart();
        while (opModeIsActive()) {
            double y = gamepad1.left_stick_y;
            double x = -gamepad1.left_stick_x;
            double h = -gamepad1.right_stick_x;
            double shooterPowerInRPM = shooterPower * (60/28);
            fr.setPower(Range.clip(y - x - h, -1, 1));
            fl.setPower(Range.clip(y + x + h, -1, 1));
            br.setPower(Range.clip(y + x - h, -1, 1));
            bl.setPower(Range.clip(y - x + h, -1, 1));
            shooter.setVelocity(shooterPower);
            telemetry.addData("Shooter Power:",60/28*shooter.getVelocity());
            telemetry.addData("Goal Velocity:", shooterPowerInRPM);
            telemetry.update();

            if (gamepad1.aWasPressed()) {
                shooterPower += 10;
            }
            else if (gamepad1.bWasPressed()) {
                shooterPower -= 10;
            }
        }

    }
}
