package org.firstinspires.ftc.teamcode.opmode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.MovePIDCommand;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.sensor.localization.Pinpoint;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.command.IntakeStart;
import org.firstinspires.ftc.teamcode.command.IntakeStop;
import org.firstinspires.ftc.teamcode.command.Shoot;

@Configurable
@Autonomous(name="Red", group = "auto")
public class AutoBluePathUnPsuedoCodedIGuess extends LinearOpMode {
    //Robot Start

    double speed;
    MechanumDrive drive;
    Pinpoint localizer;
    public void initalize() {
        localizer.setPosition(Constants.SHOOT_BLUE_FAR);
    }

    //robot.move(56,10,h)
    public void commands () {


        //Robot shoots the loaded pollen
        new Shoot();

        //Robot picks up pollen from the garden
        new MovePIDCommand(new Pose2D(134,134,0), speed, drive, localizer);

        //Robot moves to the other side
        new MovePIDCommand(new Pose2D(144-56,144-120,270), speed, drive, localizer);

        //Robot shoots the 4 pollen
        new Shoot();

        //Robot intakes pollen from closest flower
        new MovePIDCommand(new Pose2D(10,10,0), speed, drive, localizer);
        new IntakeStart();
        new IntakeStop();
        new MovePIDCommand(new Pose2D(10,10,0), speed, drive, localizer);
        //Robot shoots the 4 pollen
        new Shoot();

        //Robot parks
        new MovePIDCommand(new Pose2D(10,10,0), speed, drive, localizer);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
