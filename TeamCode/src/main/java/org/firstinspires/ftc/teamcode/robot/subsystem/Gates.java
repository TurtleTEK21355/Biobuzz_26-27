package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

public class Gates {
    Servo pollen;
    Servo nectar;
    boolean isOpen;
    public Gates(Servo pollen, Servo nectar){
        this.pollen = pollen;
        this.nectar = nectar;
    }

    public void  openGates(){
        pollen.setPosition(Constants.openGatePosition);
        nectar.setPosition(Constants.openGatePosition);
        isOpen=true;
    }
    public void closeGates(){
        pollen.setPosition(Constants.closeGatePosition);
        nectar.setPosition(Constants.closeGatePosition);
        isOpen=false;
    }
    public void toggleGate(){
        if (isOpen) {
            closeGates(); isOpen=false;}
        else        { openGates(); isOpen=true ;}
    }
}
