package org.firstinspires.ftc.teamcode.command;


import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.libcode.library.commandsinternal.Command;

public class MotorSetPower extends Command {
    DcMotor motor;
    double power;

    public MotorSetPower(DcMotor motor, double power) {
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