package org.firstinspires.ftc.libcode.examples.command;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.sensor.localization.Localizer;
import org.firstinspires.ftc.libcode.library.sensor.localization.OTOSSensor;

public class MovePIDHoldTimeCommand extends MovePIDCommand{
    private ElapsedTime holdTimer = new ElapsedTime();
    private final int holdTime;
    private boolean holdTimerStartLock = false;
    public String dataKey = "MovePIDHoldTimeCommand";



    public MovePIDHoldTimeCommand(Pose2D target, int holdTime, double speed, MechanumDrive drivetrain, Localizer localizer) {
        super(target, speed, drivetrain, localizer);
        this.holdTime = holdTime;
    }

    @Override
    public void loop() {
        super.loop();
        if (super.isCompleted() && !holdTimerStartLock) {
            holdTimer.reset();
            holdTimerStartLock = true;
        }


    }

    @Override
    public boolean isCompleted() {
        return super.isCompleted() && holdTimerStartLock && holdTimer.milliseconds() >= holdTime;
    }

}