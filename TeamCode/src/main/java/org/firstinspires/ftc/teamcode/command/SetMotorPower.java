package org.firstinspires.ftc.teamcode.command;


import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryString;

public class SetMotorPower extends Command {
    DcMotor motor;
    double power;

    public SetMotorPower(DcMotor motor, double power) {
        this.motor = motor;
    }

    @Override
    public void init() {
        motor.setPower(power);
    }

    @Override
    public boolean isCompleted() {
        return (true);

    }

}