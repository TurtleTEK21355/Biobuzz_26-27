package org.firstinspires.ftc.teamcode.opmode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.*;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.teamcode.robot.Sting;

@Configurable
@Autonomous(name= "Should Literally Just Park and if it Doesn't I'll cry", group = "auto")
public class JustPark extends LinearOpMode {
    //Robot Start

    Sting robot;
    public void initalize() {
        robot.build(hardwareMap);
        robot.getPinpoint().setPosition(new Pose2D(9, 84, 9));
    }

    public void commands () {
        new MovePIDHoldTimeCommand(new Pose2D(12,88,0), 2000, 0.6, robot.getDrivetrain(), robot.getPinpoint());
    }

    @Override
    public void runOpMode() throws InterruptedException {}
}
