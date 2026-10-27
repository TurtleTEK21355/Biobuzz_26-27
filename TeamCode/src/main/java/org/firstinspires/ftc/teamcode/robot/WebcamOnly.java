package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.libcode.library.sensor.localization.Webcam;
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;

public class WebcamOnly {
    private Webcam webcam;


    public WebcamOnly(Webcam webcam) {
        this.webcam = webcam;
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
    public static WebcamOnly build(HardwareMap hardwareMap) {
        return new WebcamOnly(new Webcam(
                hardwareMap.get(CameraName.class, "webcam"), 0, 0, 0, 0, 0, 0
        ));
    }
}
