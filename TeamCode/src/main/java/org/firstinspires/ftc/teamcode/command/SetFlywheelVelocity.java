package org.firstinspires.ftc.teamcode.command;


import org.firstinspires.ftc.teamcode.library.actuator.drivetrain.Flywheel;
import org.firstinspires.ftc.teamcode.library.commandsinternal.Command;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryString;

public class SetFlywheelVelocity extends Command {
   Flywheel flywheel;
   double velocity;

    public SetFlywheelVelocity(Flywheel flywheel, double velocity) {
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
        return (Math.abs(flywheel.getVelocity() - velocity) < 20);

    }

}