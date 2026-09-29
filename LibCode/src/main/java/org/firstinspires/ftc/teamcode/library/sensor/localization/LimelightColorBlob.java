package org.firstinspires.ftc.teamcode.library.sensor.localization;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.library.internal.Pose2D;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser;

public class LimelightColorBlob {
    // WIP !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private Limelight3A limelight;
    public LimelightColorBlob(Limelight3A limelight) {
        this.limelight = limelight;
        this.limelight.start();
    }

    public LLResult getLatestResult() {
        return limelight.getLatestResult();
    }

    public Pose2D getPositionOfBlob() {
        LLResult result = limelight.getLatestResult();
        if (result.isValid()) {
            double degreesX = 0;
            double degreesY = 0;
            double area = 0;
            for(LLResultTypes.ColorResult llData : result.getColorResults()) {
                degreesX = llData.getTargetXDegrees();
                degreesY = llData.getTargetYDegrees();
                area = llData.getTargetArea();
            }
            if (area != 0) {
             // add logic/math here   !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }
        }
        return new Pose2D();
    }

}
