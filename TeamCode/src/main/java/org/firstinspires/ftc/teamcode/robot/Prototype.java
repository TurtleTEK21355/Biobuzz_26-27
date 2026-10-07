package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.subsystem.Flywheel;

public class Prototype {
    private Flywheel flywheelNectar;
    private Flywheel flywheelPollen;
    private MechanumDrive drivetrain;
    private DcMotor intake;


    public Prototype(Flywheel flywheelPollen, Flywheel flywheelNectar, MechanumDrive drivetrain, DcMotor intake) {
        this.flywheelNectar = flywheelNectar;
        this.flywheelPollen = flywheelPollen;
        this.drivetrain = drivetrain;
        this.intake = intake;
    }
    public void setFlywheelNectarVelocity(double velocity) { flywheelNectar.setVelocity(velocity); }
    public void setFlywheelPollenVelocity(double velocity) { flywheelPollen.setVelocity(velocity); }
    public void setIntakePower(double power) { intake.setPower(power); }
    public MechanumDrive getDrivetrain() { return drivetrain; }

    public void flywheelsTelemetry(){
        TelemetryPasser.telemetry.addLine("Right Flywheel:");
        flywheelPollen.telemetry();
        TelemetryPasser.telemetry.addLine("\nLeft Flywheel:");
        flywheelNectar.telemetry();
    }


    /**
     * this is for building the robot without having to copypaste this around everywhere
     * use like:
     * robot = StateRobot.build() in init
     * if new parts are added then change this
     *
     * @return the robot
     */
    public static Prototype build(HardwareMap hardwareMap) {
        return new Prototype(
            new Flywheel(hardwareMap.get(DcMotorEx.class, PrototypeHardwareName.FLYWHEELPOLLEN.getName())),
            new Flywheel(hardwareMap.get(DcMotorEx.class, PrototypeHardwareName.FLYWHEELNECTAR.getName())),
            new MechanumDrive(
                hardwareMap.get(DcMotor.class, PrototypeHardwareName.FRONTLEFTDT.getName()),
                hardwareMap.get(DcMotor.class, PrototypeHardwareName.FRONTRIGHTDT.getName()),
                hardwareMap.get(DcMotor.class, PrototypeHardwareName.BACKLEFTDT.getName()),
                hardwareMap.get(DcMotor.class, PrototypeHardwareName.BACKRIGHTDT.getName())
            ),
            hardwareMap.get(DcMotor.class, PrototypeHardwareName.INTAKE.getName())
        );
    }

    public enum PrototypeHardwareName {
        IMU("imu"),
        FLYWHEELPOLLEN("flywheel_pollen"),
        FLYWHEELNECTAR("flywheel_nectar"),
        BACKLEFTDT("lb"),
        BACKRIGHTDT("rb"),
        FRONTLEFTDT("lf"),
        FRONTRIGHTDT("rf"),
        INTAKE("intake");


        private final String name;

        PrototypeHardwareName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
