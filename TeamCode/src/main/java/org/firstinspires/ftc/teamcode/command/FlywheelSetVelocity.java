package org.firstinspires.ftc.teamcode.command;

import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryString;
import org.firstinspires.ftc.teamcode.robot.subsystem.Flywheel;

public class FlywheelSetVelocity extends Command {
   Flywheel flywheel;
   double velocity;

    public FlywheelSetVelocity(Flywheel flywheel, double velocity) {
        this.flywheel = flywheel;
        this.velocity = velocity;
    }

    @Override
    public void init() {
        flywheel.setVelocity(velocity);
    }

    @Override
    public String telemetry() {
        TelemetryString string = new TelemetryString();
        string.addData("Flywheel Velocity: ", flywheel.getVelocity());
        return string.toString();
    }

    @Override
    public boolean isCompleted() {
        return (Math.abs(flywheel.getVelocity() - velocity) <= 20);

    }

}