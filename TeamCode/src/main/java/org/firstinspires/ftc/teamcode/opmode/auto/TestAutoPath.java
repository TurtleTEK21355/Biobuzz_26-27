package org.firstinspires.ftc.teamcode.opmode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.MovePIDCommand;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.sensor.localization.Pinpoint;

@Configurable
@Autonomous(name="Red", group = "auto")
public class TestAutoPath extends LinearOpMode {
    //Robot Start

    double speed;
    MechanumDrive drive;
    Pinpoint localizer;
    public void initalize() { localizer.setPosition(new Pose2D(0, 0, 0));}

    //robot.move(56,10,h)
    public void commands () {

        double startX = 56;
        double startY = 10;
        double edge = 10;
        double flowerX = 55; //guess
        double flowerY = 144; //guess
        double shootY = 120;
        //Robot shoots the loaded pollen

        //Robot picks up pollen from the garden
        new MovePIDCommand(new Pose2D(30,0,90), speed, drive, localizer);

        //Robot moves to the other side
        new MovePIDCommand(new Pose2D(30,30,180), speed, drive, localizer);


        //Robot intakes pollen from closest flower
        new MovePIDCommand(new Pose2D(0, 30,270), speed, drive, localizer);

        new MovePIDCommand(new Pose2D(0,0,0), speed, drive, localizer);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
