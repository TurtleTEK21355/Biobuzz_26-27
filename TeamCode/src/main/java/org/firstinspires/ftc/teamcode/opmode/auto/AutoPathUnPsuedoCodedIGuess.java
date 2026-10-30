package org.firstinspires.ftc.teamcode.opmode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.MovePIDCommand;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.sensor.localization.Pinpoint;
import org.firstinspires.ftc.teamcode.command.IntakeStart;
import org.firstinspires.ftc.teamcode.command.IntakeStop;
import org.firstinspires.ftc.teamcode.command.Shoot;
import org.firstinspires.ftc.teamcode.Constants;

@Configurable
@Autonomous(name="Red", group = "auto")
public class AutoPathUnPsuedoCodedIGuess extends LinearOpMode {
    //Robot Start

    double speed;
    MechanumDrive drive;
    Pinpoint localizer;
    public void initalize() {
        localizer.setPosition(Constants.START_RED_FAR);
    }

    //robot.move(56,10,h)
    public void commands () {

        double startX = 56;
        double startY = 10;
        double edge = 10;
        double flowerX = 55; //guess
        double flowerY = 144; //guess
        double shootY = 120;
        //Robot shoots the loaded pollen
        new Shoot();

        //Robot picks up pollen from the garden
        new MovePIDCommand(new Pose2D(edge,startY,0), speed, drive, localizer);

        //Robot moves to the other side
        new MovePIDCommand(new Pose2D(startX,shootY,270), speed, drive, localizer);

        //Robot shoots the 4 pollen
        new Shoot();

        //Robot intakes pollen from closest flower
        new MovePIDCommand(new Pose2D(flowerX,flowerY,0), speed, drive, localizer);
        new IntakeStart();
        new IntakeStop();
        new MovePIDCommand(new Pose2D(startX,shootY,0), speed, drive, localizer);
        //Robot shoots the 4 pollen
        new Shoot();

        //Robot parks
        new MovePIDCommand(new Pose2D(edge,72,0), speed, drive, localizer);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
