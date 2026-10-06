package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.GoBildaPinpoint;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.subsystem.Flywheel;
import org.firstinspires.ftc.teamcode.library.actuator.drivetrain.MechanumDrive;
import org.firstinspires.ftc.teamcode.library.sensor.localization.Pinpoint;

public class FlywheelPrototype {
    private Flywheel flywheelLeft;
    private Flywheel flywheelRight;


    public FlywheelPrototype(Flywheel flywheelLeft, Flywheel flywheelRight) {
        this.flywheelLeft = flywheelLeft;
        this.flywheelRight = flywheelRight;
    }
    public void setFlywheelLeftVelocity(double velocity) { flywheelLeft.setVelocity(velocity); }
    public void setFlywheelRightVelocity(double velocity) { flywheelRight.setVelocity(velocity); }

    public void flywheelsTelemetry(){
        TelemetryPasser.telemetry.addLine("Right Flywheel:");
        flywheelRight.telemetry();
        TelemetryPasser.telemetry.addLine("\nLeft Flywheel:");
        flywheelLeft.telemetry();
    }


    /**
     * this is for building the robot without having to copypaste this around everywhere
     * use like:
     * robot = StateRobot.build() in init
     * if new parts are added then change this
     *
     * @return the robot
     */
    public static FlywheelPrototype build(HardwareMap hardwareMap) {
        return new FlywheelPrototype(
                new Flywheel(hardwareMap.get(DcMotorEx.class, FlywheelPrototypeHardwareName.FLYWHEELPOLLEN.getName())),
                new Flywheel(hardwareMap.get(DcMotorEx.class, FlywheelPrototypeHardwareName.FLYWHEELNECTAR.getName()))

        );
    }

    public enum FlywheelPrototypeHardwareName {
        IMU("imu"),
        FLYWHEELPOLLEN("flywheel_pollen"),
        FLYWHEELNECTAR("flywheel_nectar");

        private final String name;

        FlywheelPrototypeHardwareName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
