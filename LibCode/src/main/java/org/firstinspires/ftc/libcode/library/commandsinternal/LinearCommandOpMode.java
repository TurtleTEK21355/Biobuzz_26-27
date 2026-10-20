package org.firstinspires.ftc.libcode.library.commandsinternal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;

public abstract class LinearCommandOpMode extends LinearOpMode {
    private CommandScheduler commandScheduler = new CommandScheduler();

    @Override
    public void runOpMode() {
        initialize(); //where you put in commands and configuration
        while (!commandScheduler.isCompleted() && opModeIsActive()) {
            commandScheduler.loop();
            TelemetryPasser.telemetry.update();
        }
        cleanup(); //for blackboard or resetting of odometry
    }

    public abstract void initialize();
    public abstract void cleanup();

    public void addCommand(Command command) {
        commandScheduler.add(command);
    }

}
