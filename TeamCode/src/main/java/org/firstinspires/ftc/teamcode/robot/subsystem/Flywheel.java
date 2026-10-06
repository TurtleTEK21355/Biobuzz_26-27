package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.examples.robot.Constants;
import org.firstinspires.ftc.teamcode.library.internal.Pose2D;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser;

/**
 * <div style="background-color: #0CA366; color: black; border-bottom: 4px dashed black;">
 * <h1>Mechanum Drive</h1>
 * <p>This drivetrain type uses 4 mechanum wheels in a standard linear setup.
 * This layout allows for optimal control on a flat surface.
 * Due to the nature of mechanum wheel,
 * this drivetrain type is not optimal for slopes or rough surfaces.</p>
 * </div>
 * <div style="background-color: #009AD2; color: black; border-top: 4px dashed black;">
 * <h6>Strengths:</h4>
 * <ul>
 *     <li>Linear Movement</li>
 *     <li>Strafing</li>
 *     <li>Rotation</li>
 *     <li>Agility</li>
 * </ul>
 * <h6>Weaknesses</h6>
 * <ul>
 *     <li>Prone to slipping</li>
 *     <li>Only works on flat surfaces</li>
 * </ul>
 * </div>
 * @author Phillip
 * @author Noah
 * @since 03/15/2026
 * @version 0.1.0 (04/02/2026)
 */
public class Flywheel {
    private final DcMotorEx flywheel;

    public Flywheel(DcMotorEx flywheel){
        this.flywheel = flywheel;
        this.flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.flywheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    /**
     * @param velocity velocity in Degrees per Second
     */
    public void setVelocity(double velocity){
        flywheel.setVelocity(velocity, AngleUnit.DEGREES);
    }

    /**
     * @return velocity in Degrees per Second
     */
    public double getVelocity(){
        return flywheel.getVelocity(AngleUnit.DEGREES);
    }

    /**
     * @param power (-1 to 1)
     */
    public void setPower(double power){
        flywheel.setPower(power);
    }

    /**
     * @return (-1 to 1)
     */
    public double getPower(){
        return flywheel.getPower();
    }

    public void telemetry() {
        TelemetryPasser.telemetry.addLine()
                .addData("Flywheel Power: ", flywheel.getPower())
                .addData("Flywheel Velocity (Degrees per Second): ", flywheel.getVelocity(AngleUnit.DEGREES));
    }
}