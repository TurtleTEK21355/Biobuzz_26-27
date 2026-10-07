package org.firstinspires.ftc.teamcode.command;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryString;
import org.firstinspires.ftc.teamcode.robot.subsystem.Flywheel;

public class SetMotorVelocity extends Command {
   DcMotorEx motor;
   double velocity;
   double tolerance;

    public SetMotorVelocity(DcMotorEx motor, double velocity, double tolerance) {
        this.motor = motor;
        this.velocity = velocity;
        this.tolerance = tolerance;
    }

    @Override
    public void init() {
        motor.setVelocity(velocity);
    }

    @Override
    public String telemetry() {
        TelemetryString string = new TelemetryString();
        string.addData(motor.getDeviceName()+" Motor Velocity: ", motor.getVelocity());
        return string.toString();
    }

    @Override
    public boolean isCompleted() {
        return (Math.abs(motor.getVelocity() - velocity) < tolerance);

    }

}