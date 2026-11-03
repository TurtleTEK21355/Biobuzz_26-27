package org.firstinspires.ftc.teamcode.opmode.teleop;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.libcode.library.internal.Pose2D;

public class Controls {
    Pose2D drive = new Pose2D(0,0,0);
    public void feed(Gamepad gamepad1, Gamepad gamepad2) {
        drive = new Pose2D(gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);

    }
}
