package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.libcode.hardware.GoBildaPinpoint;
import org.firstinspires.ftc.libcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.libcode.library.sensor.localization.LimelightColorBlob;
import org.firstinspires.ftc.libcode.library.sensor.localization.Pinpoint;
import org.firstinspires.ftc.libcode.library.sensor.localization.Webcam;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.teamcode.robot.subsystem.Flywheel;
import org.firstinspires.ftc.teamcode.robot.subsystem.Gates;

public class Sting {

    private Flywheel flywheelNectar;
    private Flywheel flywheelPollen;
    private Gates gates;
    private MechanumDrive drivetrain;
    private DcMotor intake;
    private Webcam webcam;
    private LimelightColorBlob limelight;
    private Pinpoint pinpoint;


    public Sting(Flywheel flywheelPollen, Flywheel flywheelNectar, Gates gates, MechanumDrive drivetrain, DcMotor intake, Webcam webcam, LimelightColorBlob limelight, Pinpoint pinpoint) {
        this.flywheelNectar = flywheelNectar;
        this.flywheelPollen = flywheelPollen;
        this.gates = gates;
        this.drivetrain = drivetrain;
        this.intake = intake;
        this.webcam = webcam;
        this.limelight = limelight;
        this.pinpoint = pinpoint;
    }
    public void setFlywheelNectarVelocity(double velocity) { flywheelNectar.setVelocity(velocity); }
    public void setFlywheelPollenVelocity(double velocity) { flywheelPollen.setVelocity(velocity); }
    public void setIntakePower(double power) { intake.setPower(power); }
    public MechanumDrive getDrivetrain() { return drivetrain; }
    public Flywheel getFlywheelPollen() { return flywheelPollen; }
    public Flywheel getFlywheelNectar() { return flywheelNectar; }

    public Webcam getWebcam() { return webcam; }
    public LimelightColorBlob getLimelight() { return limelight; }
    public Pinpoint getPinpoint() { return pinpoint; }
    public Gates getGates() { return gates; }

    public void flywheelsTelemetry(){
        TelemetryPasser.telemetry.addLine("\nRight Flywheel:");
        flywheelPollen.telemetry();
        TelemetryPasser.telemetry.addLine("\nLeft Flywheel:");
        flywheelNectar.telemetry();
        TelemetryPasser.telemetry.addLine("\n");

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
            new Flywheel(hardwareMap.get(DcMotorEx.class, StingHardwareName.FLYWHEELPOLLEN.getName())),
            new Flywheel(hardwareMap.get(DcMotorEx.class, StingHardwareName.FLYWHEELNECTAR.getName())),
            new Gates(
                    hardwareMap.get(Servo.class, StingHardwareName.GATEPOLLEN.getName()),
                    hardwareMap.get(Servo.class, StingHardwareName.GATENECTAR.getName())),
            new MechanumDrive(
                hardwareMap.get(DcMotor.class, StingHardwareName.FRONTLEFTDT.getName()),
                hardwareMap.get(DcMotor.class, StingHardwareName.FRONTRIGHTDT.getName()),
                hardwareMap.get(DcMotor.class, StingHardwareName.BACKLEFTDT.getName()),
                hardwareMap.get(DcMotor.class, StingHardwareName.BACKRIGHTDT.getName())),
            hardwareMap.get(DcMotor.class, StingHardwareName.INTAKE.getName()),
            new Webcam(hardwareMap.get(CameraName.class, StingHardwareName.WEBCAM.getName()), 0, 0, 0, 0, 45, 0),
            new LimelightColorBlob(hardwareMap.get(Limelight3A.class, StingHardwareName.LIMELIGHT.getName())),
            new Pinpoint(hardwareMap.get(GoBildaPinpoint.class, StingHardwareName.PINPOINT.getName()))
        );
    }

    public enum StingHardwareName {
        IMU("imu"),
        FLYWHEELPOLLEN("flywheel_pollen"),
        FLYWHEELNECTAR("flywheel_nectar"),
        GATEPOLLEN("gate_pollen"),
        GATENECTAR("gate_nectar"),
        BACKLEFTDT("lb"),
        BACKRIGHTDT("rb"),
        FRONTLEFTDT("lf"),
        FRONTRIGHTDT("rf"),
        INTAKE("intake"),
        WEBCAM("webcam"),
        LIMELIGHT("limelight"),
        PINPOINT("pinpoint");

        private final String name;

        StingHardwareName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
