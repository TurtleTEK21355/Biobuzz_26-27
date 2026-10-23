package org.firstinspires.ftc.libcode.library.sensor.localization;

import android.util.Size;

import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagSingleDetection;

import java.util.List;

public class Webcam {

    private AprilTagProcessor aprilTag;
    private VisionPortal visionPortal;
    private List<AprilTagDetection> currentDetections;


    public Webcam(CameraName camera, double x, double y, double z, double yaw, double pitch, double roll) {
        aprilTag = new AprilTagProcessor.Builder()

        {// The following default settings are available to un-comment and edit as needed.
                //.setDrawAxes(false)
                //.setDrawCubeProjection(false)
                //.setDrawTagOutline(true)

                // == CAMERA CALIBRATION ==
                // If you do not manually specify calibration parameters, the SDK will attempt
                // to load a predefined calibration for your camera.
                //.setLensIntrinsics(578.272, 578.272, 402.145, 221.506)
                // ... these parameters are fx, fy, cx, cy.
        }
                .setCameraPose(new Position(DistanceUnit.INCH, x,y,z,0), new YawPitchRollAngles(AngleUnit.DEGREES, yaw, pitch, roll, 0))
                .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                .setTagLibrary(AprilTagGameDatabase.getCurrentGameTagLibrary())
                .setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)
                .build();

        {// Adjust Image Decimation to trade-off detection-range for detection-rate.
            // eg: Some typical detection data using a Logitech C920 WebCam
            // Decimation = 1 ..  Detect 2" Tag from 10 feet away at 10 Frames per second
            // Decimation = 2 ..  Detect 2" Tag from 6  feet away at 22 Frames per second
            // Decimation = 3 ..  Detect 2" Tag from 4  feet away at 30 Frames Per Second (default)
            // Decimation = 3 ..  Detect 5" Tag from 10 feet away at 30 Frames Per Second (default)
            // Note: Decimation can be changed on-the-fly to adapt during a match.
        }
            aprilTag.setDecimation(1);


        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera
        builder.setCamera(camera);

        // Choose a camera resolution. Not all cameras support all resolutions.
        builder.setCameraResolution(new Size(640, 480));

        // Enable the RC preview (LiveView).  Set "false" to omit camera monitoring.
        builder.enableLiveView(true);

        // Set the stream format; MJPEG uses less bandwidth than default YUY2.
        builder.setStreamFormat(VisionPortal.StreamFormat.MJPEG);

        // Choose whether or not LiveView stops if no processors are enabled.
        // If set "true", monitor shows solid orange screen if no processors enabled.
        // If set "false", monitor shows camera view without annotations.
        builder.setAutoStopLiveView(false);

        // Set and enable the processor.
        builder.addProcessor(aprilTag);

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build();

        // Disable or re-enable the aprilTag processor at any time.
        visionPortal.setProcessorEnabled(aprilTag, true);
    }

    public String returnAllAprilTagDataAsString() {
        StringBuilder outputString = new StringBuilder();
        for (AprilTagDetection detection : currentDetections) {
            // TODO: Update to new vision APIS
            if ( detection instanceof AprilTagSingleDetection ) {
                // Create local copy of detection but casting to AprilTagSingleDetection type
                // so that we can properly interpret the metadata and id information.
                AprilTagSingleDetection singleDet = (AprilTagSingleDetection) detection;
                if (singleDet.metadata != null) {
                    outputString.append("ID ")
                            .append(singleDet.id)
                            .append("\nx ")
                            .append(singleDet.ftcPose.x)
                            .append("\ny ")
                            .append(singleDet.ftcPose.y)
                            .append("\nz ")
                            .append(singleDet.ftcPose.z)
                            .append("\npitch ")
                            .append(singleDet.ftcPose.pitch)
                            .append("\nroll ")
                            .append(singleDet.ftcPose.roll)
                            .append("\nyaw ")
                            .append(singleDet.ftcPose.yaw);
                } else {
                    outputString.append("\nDetection Unknown");
                }
                outputString.append("\n");
            }
        }
        return outputString.toString();
    }

    public DetectionPosition returnAprilTagPosition() {
        StringBuilder outputString = new StringBuilder();
        for (AprilTagDetection detection : currentDetections) {
            // TODO: Update to new vision APIS
            if ( detection instanceof AprilTagSingleDetection ) {
                // Create local copy of detection but casting to AprilTagSingleDetection type
                // so that we can properly interpret the metadata and id information.
                AprilTagSingleDetection singleDet = (AprilTagSingleDetection) detection;
                if (singleDet.metadata != null) {
                }
            }
        }
        return null;
    }

    public void updateDetections() {
        currentDetections = aprilTag.getDetections();
    }

    public AprilTagDetection getDetection(int id) {
        for (AprilTagDetection detection : currentDetections) {
            // TODO: Update to new vision APIS
//            if (detection.metadata != null) {
//                if (detection.id == id) {
//                    return detection;
//                }
//            }

        }
        return null;
    }

    public Double getRange(AprilTagDetection detection) {
        // TODO: Update to new vision APIS
//        if (detection != null && detection.metadata != null) {
//            return detection.ftcPose.range;
//        }
        return null;
    }

    public Pose2D getRelativePositionFromTag(Pose2D currentPosition, int tagID) { //gotta pass in the current because otherwise it will reset the position every time it doesn't detect a goal
        AprilTagDetection specifiedTagDetection = getDetection(tagID);
        if (specifiedTagDetection != null) {
            Pose2D specifedTagRelativePosition = new Pose2D(specifiedTagDetection.robotPose);
            TelemetryPasser.telemetry.addData("tagRelativePos", specifedTagRelativePosition);
            TelemetryPasser.telemetry.addData("distancetotag", currentPosition.distanceTo(specifedTagRelativePosition));
        }
        return currentPosition;
    }

}