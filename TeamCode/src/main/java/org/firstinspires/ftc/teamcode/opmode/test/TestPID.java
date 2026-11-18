package org.firstinspires.ftc.teamcode.opmode.test;

//import com.bylazar.configurables.annotations.Configurable;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.libcode.examples.command.MovePIDCommand;
import org.firstinspires.ftc.libcode.hardware.GoBildaPinpoint;
import org.firstinspires.ftc.libcode.library.commandsinternal.LinearCommandOpMode;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.teamcode.robot.Sting;

//@Configurable
@Autonomous(name= "Test PID", group = "auto")
public class TestPID extends LinearCommandOpMode {
    //Robot Start

    Sting robot;
    Pose2D tolerance = new Pose2D(1.5,1.5,2.5);

    @Override
    public void initialize() {
        robot = Sting.build(hardwareMap);
        robot.getPinpoint().setPodOffsets(-177, -9);
        robot.getPinpoint().setPodDirections(GoBildaPinpoint.EncoderDirection.REVERSED, GoBildaPinpoint.EncoderDirection.FORWARD);
        robot.getPinpoint().resetPosition();
        sleep(300);
//        robot.getPinpoint().setPosition(new Pose2D(9, 84, 180));
        commands();
    }

    public void commands () {

//        addCommand(new MovePIDCommand(new Pose2D(12,88,180), 1, robot.getDrivetrain(), robot.getPinpoint(), tolerance));
        addCommand(new MovePIDCommand(new Pose2D(-4,4,0), 0, robot.getDrivetrain(), robot.getPinpoint(), tolerance));

    }

    @Override
    public void runOpMode() {
        super.runOpMode();
    }

    @Override
    public void cleanup() {

    }
}
