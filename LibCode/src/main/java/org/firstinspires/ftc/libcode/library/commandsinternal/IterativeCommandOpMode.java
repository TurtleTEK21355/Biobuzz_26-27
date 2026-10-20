package org.firstinspires.ftc.libcode.library.commandsinternal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
public abstract class IterativeCommandOpMode extends OpMode {
    private CommandScheduler commandScheduler = new CommandScheduler();

    @Override
    public void init() {
        initialize(); //where you put in commands and configuration

    }

    @Override
    public void loop() {
        commandScheduler.loop();

        if (commandScheduler.isCompleted()) {
            requestOpModeStop();
        }

    }

    @Override
    public void stop() {
        cleanup(); //for blackboard or resetting of odometry
    }

    public abstract void initialize();
    public abstract void cleanup();

    public void addCommand(Command command) {
        commandScheduler.add(command);
    }

}
