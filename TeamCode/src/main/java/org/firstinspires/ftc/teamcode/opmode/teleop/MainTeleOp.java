package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.libcode.library.commandsinternal.CommandScheduler;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.Sting;

@Configurable
@TeleOp(name = "TeleOp", group = "teleop")
public class MainTeleOp extends OpMode {
    protected Sting robot;
    private final CommandScheduler commandScheduler = new CommandScheduler();

    @Override
    public void init() {
        TelemetryPasser.telemetry = telemetry;
        robot = Sting.build(hardwareMap);

        telemetry.addLine("Controls here");
    }

    @Override
    public void loop() {

        if (gamepad1.back) {
            robot.getPinpoint().resetPosition();
        }
        telemetry.addData("Position (Pinpoint)", robot.getPinpoint().getPosition());

        commandScheduler.loop();
        telemetry.addLine(commandScheduler.getTelemetry());
        if (commandScheduler.isCompleted()) { //these things only run while the robot is not shooting

        }
        telemetry.update();

    }
}
