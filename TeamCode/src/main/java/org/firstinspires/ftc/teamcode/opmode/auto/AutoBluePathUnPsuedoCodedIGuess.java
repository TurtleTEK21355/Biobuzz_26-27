package org.firstinspires.ftc.teamcode.opmode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.libcode.examples.command.MovePIDCommand;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.sensor.localization.Pinpoint;
import org.firstinspires.ftc.teamcode.command.IntakeStartCommand;
import org.firstinspires.ftc.teamcode.command.IntakeStopCommand;
import org.firstinspires.ftc.teamcode.command.ShootCommand;

@Configurable
@Autonomous(name="Red", group = "auto")
public class AutoBluePathUnPsuedoCodedIGuess {
    //Robot Start

    double speed;
    MechanumDrive drive;
    Pinpoint localizer;
    public void initalize() {
        localizer.setPosition(new Pose2D(56, 9, 90));
    }

    //robot.move(56,10,h)
    public void commands () {


        //Robot shoots the loaded pollen
        new ShootCommand();

        //Robot picks up pollen from the garden
        new MovePIDCommand(new Pose2D(134,134,0), speed, drive, localizer);

        //Robot moves to the other side
        new MovePIDCommand(new Pose2D(144-56,144-120,270), speed, drive, localizer);

        //Robot shoots the 4 pollen
        new ShootCommand();

        //Robot intakes pollen from closest flower
        new MovePIDCommand(new Pose2D(10,10,0), speed, drive, localizer);
        new IntakeStartCommand();
        new IntakeStopCommand();
        new MovePIDCommand(new Pose2D(10,10,0), speed, drive, localizer);
        //Robot shoots the 4 pollen
        new ShootCommand();

        //Robot parks
        new MovePIDCommand(new Pose2D(10,10,0), speed, drive, localizer);
    }
}
