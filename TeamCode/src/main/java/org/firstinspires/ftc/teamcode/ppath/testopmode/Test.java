package org.firstinspires.ftc.teamcode.ppath.testopmode;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ppath.Constants;

@Autonomous
public class Test extends OpMode {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }
}
