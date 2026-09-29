package org.firstinspires.ftc.teamcode.library.sensor.localization;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.library.internal.Pose2D;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser;

public class LimelightAprilTag {
    private Limelight3A limelight;
    private final double LL_POSITION_TOLERANCE = 5;
    private final double METERS_TO_INCHES = 39.3700787;
    public LimelightAprilTag(Limelight3A limelight) {
        this.limelight = limelight;
        this.limelight.start();
    }
    public void telemetryLimelightAprilTagData(Pose2D position){
        limelight.updateRobotOrientation(position.h);
        LLResult result = limelight.getLatestResult();
        Pose3D botpose = result.getBotpose_MT2();
        if (botpose != null) {
            TelemetryPasser.telemetry.addData("Field Position From AprilTags: ", botpose.toString());
        } else {
            TelemetryPasser.telemetry.addData("Field Position From AprilTags: ", "No Active Detections");
        }
    }

    public void updateRobotOrientation(double yaw) {
        limelight.updateRobotOrientation((yaw - 180) % 360);
    }

    public LLResult getLatestResult() {
        return limelight.getLatestResult();
    }

    public Pose2D getPositionFromTags() {
        LLResult result = limelight.getLatestResult();
        if (result.isValid()) {
            return new Pose2D(
                    result.getBotpose_MT2().getPosition().y * METERS_TO_INCHES,
                    -result.getBotpose_MT2().getPosition().x * METERS_TO_INCHES,
                    result.getBotpose_MT2().getOrientation().getYaw()
            );
        }
        else {
            return new Pose2D();
        }
    }
    public Double getAngleFromTag(){
        LLResult result = limelight.getLatestResult();
        Double degrees = null;
        for (LLResultTypes.FiducialResult llData : result.getFiducialResults()) {
            if (degrees != null) degrees = Math.min(degrees, llData.getTargetXDegrees()); // always uses leftmost tag for consistency
            else degrees = llData.getTargetXDegrees();
        }
        return degrees;
    }
    public Double getAngleFromTag(int tagID){
        LLResult result = limelight.getLatestResult();
        Double degrees = null;
        for (LLResultTypes.FiducialResult llData : result.getFiducialResults()) {
            if (llData.getFiducialId() == tagID) degrees = llData.getTargetXDegrees();
        }
        return degrees;
    }
    public Pose2D getCorrectedPositionFromLL(Pose2D currentPosition){
        LLResult result = limelight.getLatestResult();
        Pose2D llPosition = new Pose2D(
                result.getBotpose_MT2().getPosition().y * METERS_TO_INCHES,
                -result.getBotpose_MT2().getPosition().x * METERS_TO_INCHES,
                currentPosition.h
        );
        if (result.isValid() && llPosition.distanceTo(currentPosition) > LL_POSITION_TOLERANCE) {
            return llPosition;
        }
        else {
            return currentPosition;
        }
    }
}
