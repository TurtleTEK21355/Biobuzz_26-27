package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class FlowerMechanism {
    Servo servo;
    boolean isOpen;
    public FlowerMechanism(Servo servo) { this.servo = servo; }
    public void open()  {servo.setPosition(Constants.flowerMechanismUpPosition);   isOpen=true;}
    public void close() {servo.setPosition(Constants.flowerMechanismDownPosition); isOpen=false;}
    public void toggle() {
        if (isOpen) {close(); isOpen=false;}
        else        {open();  isOpen=true;}
    }
}
