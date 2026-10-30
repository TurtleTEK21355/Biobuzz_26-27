package org.firstinspires.ftc.teamcode.opmode.auto;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.examples.command.TimerCommand;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.command.GatesClose;
import org.firstinspires.ftc.teamcode.command.GatesOpen;
import org.firstinspires.ftc.teamcode.command.FlywheelSetVelocity;
import org.firstinspires.ftc.teamcode.command.OuttakeWheelsStart;
import org.firstinspires.ftc.teamcode.command.OuttakeWheelsStop;
import org.firstinspires.ftc.teamcode.robot.Sting;

@Configurable
@Autonomous(name= "Should Literally Just Shoot and if it Doesn't I'll cry", group = "auto")
public class JustShoot extends LinearOpMode {
    //Robot Start

    Sting robot;
    public void initalize() { robot.build(hardwareMap); robot.getPinpoint().resetPosition();}

    public void commands () {
        new FlywheelSetVelocity(robot.getFlywheelNectar(), Constants.shootingVelocityNectar);
        new FlywheelSetVelocity(robot.getFlywheelNectar(), Constants.shootingVelocityPollen);
        new GatesOpen(robot.getGates());
        new OuttakeWheelsStart(null);
        new TimerCommand(4000);
        new GatesClose(robot.getGates());
        new OuttakeWheelsStop(null);
        new FlywheelSetVelocity(robot.getFlywheelNectar(), 0);
        new FlywheelSetVelocity(robot.getFlywheelNectar(), 0);
    }

    @Override
    public void runOpMode() throws InterruptedException {}
}
