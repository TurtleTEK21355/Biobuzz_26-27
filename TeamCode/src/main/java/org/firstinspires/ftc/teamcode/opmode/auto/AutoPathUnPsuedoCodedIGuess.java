package org.firstinspires.ftc.teamcode.opmode.auto;

//import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.MovePIDCommand;
import org.firstinspires.ftc.libcode.examples.command.TimerCommand;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.commandsinternal.LinearCommandOpMode;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.sensor.localization.Pinpoint;
import org.firstinspires.ftc.teamcode.command.IntakeStart;
import org.firstinspires.ftc.teamcode.command.IntakeStop;
import org.firstinspires.ftc.teamcode.command.Shoot;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.robot.Sting;

//@Configurable
@Autonomous(name="Yeah", group = "auto")
public class AutoPathUnPsuedoCodedIGuess extends LinearCommandOpMode {
    //Robot Start

    double speed = 0.5;
    Pose2D tolerance = new Pose2D(1.5,1.5,0.2);
    Sting robot;
    @Override
    public void initialize() {
        robot = Sting.build(hardwareMap);
        robot.getPinpoint().setPosition(new Pose2D(56, 9, 90));
    }



    //robot.move(56,10,h)
    public void commands () {

        double startX = 56;
        double startY = 9;
        double edge = 10;
        double flowerX = 55; //guess
        double flowerY = 144; //guess
        double shootY = 120;
        //Robot shoots the loaded pollen
        //new Shoot();

        //Robot picks up pollen from the garden
        addCommand(new MovePIDCommand(new Pose2D(edge,startY,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance));

        //Robot moves to the other side  
        addCommand(new MovePIDCommand(new Pose2D(startX,shootY,270), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance));

        //Robot shoots the 4 pollen
        //new Shoot();
        //Robot intakes pollen from closest flower
        addCommand(new MovePIDCommand(new Pose2D(flowerX,flowerY,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance));
        //new IntakeStart();
        //   new IntakeStop();
        addCommand(new MovePIDCommand(new Pose2D(startX,shootY,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance));
        //Robot shoots the 4 pollen
        //new Shoot();

        //Robot parks
        addCommand(new MovePIDCommand(new Pose2D(edge,72,0), speed, robot.getDrivetrain(), robot.getPinpoint(), tolerance));
    }

    @Override
    public void runOpMode() {
        super.runOpMode();
    }

    @Override
    public void cleanup() {
    }
}
