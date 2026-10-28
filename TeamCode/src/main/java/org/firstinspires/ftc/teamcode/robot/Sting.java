package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.libcode.library.sensor.localization.LimelightColorBlob;
import org.firstinspires.ftc.libcode.library.sensor.localization.Webcam;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.teamcode.robot.subsystem.Flywheel;

public class Sting {

    private IMU imu;
    private Flywheel flywheelNectar;
    private Flywheel flywheelPollen;
    private MechanumDrive drivetrain;
    private DcMotor intake;
    private Webcam webcam;
    private LimelightColorBlob limelight;


    public Sting(IMU imu, Flywheel flywheelPollen, Flywheel flywheelNectar, MechanumDrive drivetrain, DcMotor intake, Webcam webcam, LimelightColorBlob limelight) {
        this.imu = imu;
        this.flywheelNectar = flywheelNectar;
        this.flywheelPollen = flywheelPollen;
        this.drivetrain = drivetrain;
        this.intake = intake;
        this.webcam = webcam;
        this.limelight = limelight;
    }
    public void setFlywheelNectarVelocity(double velocity) { flywheelNectar.setVelocity(velocity); }
    public void setFlywheelPollenVelocity(double velocity) { flywheelPollen.setVelocity(velocity); }
    public void setIntakePower(double power) { intake.setPower(power); }
    public MechanumDrive getDrivetrain() { return drivetrain; }
    public IMU getIMU() { return imu; }

    public void flywheelsTelemetry(){
        TelemetryPasser.telemetry.addLine("Right Flywheel:");
        flywheelPollen.telemetry();
        TelemetryPasser.telemetry.addLine("\nLeft Flywheel:");
        flywheelNectar.telemetry();
    }

    public void webcamTelemetry(){
        TelemetryPasser.telemetry.addData("robotPose: ", webcam.robotGlobalPositionFromTag());
        TelemetryPasser.telemetry.addData("ftcPose: ", webcam.robotRelativePositionFromTag());
    }


    /**
     * this is for building the robot without having to copypaste this around everywhere
     * use like:
     * robot = StateRobot.build() in init
     * if new parts are added then change this
     *
     * @return the robot
     */
    public static Sting build(HardwareMap hardwareMap) {
        return new Sting(
            hardwareMap.get(IMU.class, StingHardwareName.IMU.getName()),
            new Flywheel(hardwareMap.get(DcMotorEx.class, StingHardwareName.FLYWHEELPOLLEN.getName())),
            new Flywheel(hardwareMap.get(DcMotorEx.class, StingHardwareName.FLYWHEELNECTAR.getName())),
            new MechanumDrive(
                hardwareMap.get(DcMotor.class, StingHardwareName.FRONTLEFTDT.getName()),
                hardwareMap.get(DcMotor.class, StingHardwareName.FRONTRIGHTDT.getName()),
                hardwareMap.get(DcMotor.class, StingHardwareName.BACKLEFTDT.getName()),
                hardwareMap.get(DcMotor.class, StingHardwareName.BACKRIGHTDT.getName())),
            hardwareMap.get(DcMotor.class, StingHardwareName.INTAKE.getName()),
            new Webcam(hardwareMap.get(CameraName.class, StingHardwareName.WEBCAM.getName()), 0, 0, 0, 0, 45, 0),
            new LimelightColorBlob(hardwareMap.get(Limelight3A.class, StingHardwareName.LIMELIGHT.getName()))
        );
    }

    public enum StingHardwareName {
        IMU("imu"),
        FLYWHEELPOLLEN("flywheel_pollen"),
        FLYWHEELNECTAR("flywheel_nectar"),
        BACKLEFTDT("lb"),
        BACKRIGHTDT("rb"),
        FRONTLEFTDT("lf"),
        FRONTRIGHTDT("rf"),
        INTAKE("intake"),
        WEBCAM("webcam"),
        LIMELIGHT("limelight");

        private final String name;

        StingHardwareName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
