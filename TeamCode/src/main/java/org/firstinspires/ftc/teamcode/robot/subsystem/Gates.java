package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Gates {
    Servo pollen;
    Servo nectar;
    boolean isOpen;
    public Gates(Servo pollen, Servo nectar) {
        this.pollen = pollen;
        this.nectar = nectar;
    }

    public void open() {
        pollen.setPosition(Constants.gateOpenPosition);
        nectar.setPosition(Constants.gateOpenPosition);
        isOpen=true;
    }
    public void close() {
        pollen.setPosition(Constants.gateClosePosition);
        nectar.setPosition(Constants.gateClosePosition);
        isOpen=false;
    }
    public void toggle() {
        if (isOpen) {close(); isOpen=false;}
        else        {open();  isOpen=true;}
    }
}
