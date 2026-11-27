package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.Constants;

public class Gates {
    private Servo pollen;
    private Servo nectar;

    private boolean isOpen;
    public Gates(Servo pollen, Servo nectar) {
        this.pollen = pollen;
        this.nectar = nectar;
        pollen.setDirection(Servo.Direction.REVERSE);
        nectar.setDirection(Servo.Direction.FORWARD);

    }

    public boolean isOpen() {
        return isOpen;
    }
    public void     open() {
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

    public double getPositionPollen() {
        return pollen.getPosition();
    }

    public void manualSetPositionPollen(double position) {
        pollen.setPosition(Range.clip(position, 0, 1));
    }
}
