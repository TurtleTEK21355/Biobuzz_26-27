package org.firstinspires.ftc.teamcode.opmode.auto;

//import com.bylazar.configurables.annotations.Configurable;
import com.pedropathing.math.Pose;
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
import org.firstinspires.ftc.teamcode.robot.Sting;

//@Configurable
@Autonomous(name="Blue", group = "auto")
public class AutoBluePathUnPsuedoCodedIGuess extends LinearOpMode {
    //Robot Start

    double speed;
    Pose2D tolerance = new Pose2D(1.5,1.5,0.2);
    Sting robot;
    public void initalize() {
        robot = Sting.build(hardwareMap);
        robot.getPinpoint().setPosition(new Pose2D(56, 9, 90));
    }

    //robot.move(56,10,h)
    public void commands () {


        //Robot shoots the loaded pollen
        new Shoot();

        //Robot picks up pollen from the garden
        new MovePIDCommand(new Pose2D(134,134,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance);

        //Robot moves to the other side
        new MovePIDCommand(new Pose2D(144-56,144-120,270), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance);

        //Robot shoots the 4 pollen
        new Shoot();

        //Robot intakes pollen from closest flower
        new MovePIDCommand(new Pose2D(10,10,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance);
        new IntakeStart();
        new IntakeStop();
        new MovePIDCommand(new Pose2D(10,10,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance);
        //Robot shoots the 4 pollen
        new Shoot();

        //Robot parks
        new MovePIDCommand(new Pose2D(10,10,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance);
    }

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
