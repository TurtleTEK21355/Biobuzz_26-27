/*   MIT License
 *   Copyright (c) [2025] [Base 10 Assets, LLC]
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:

 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.

 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *   SOFTWARE.
 */

package org.firstinspires.ftc.teamcode.library.sensor.localization;

import static org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser.telemetry;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.UnnormalizedAngleUnit;
import org.firstinspires.ftc.teamcode.hardware.GoBildaPinpoint;
import org.firstinspires.ftc.teamcode.library.internal.Pose2D;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryPasser;


import java.util.Locale;


public class Pinpoint implements Localizer{

    GoBildaPinpoint pinpoint;

    public Pinpoint(GoBildaPinpoint pinpoint) {

        this.pinpoint = pinpoint;
        this.pinpoint.setEncoderResolution(GoBildaPinpoint.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        this.pinpoint.setEncoderDirections(GoBildaPinpoint.EncoderDirection.FORWARD,
                                           GoBildaPinpoint.EncoderDirection.FORWARD);
        this.pinpoint.resetPosAndIMU();
    }
    public Pose2D getPosition(){
        pinpoint.update();
        return pinpoint.getPosition();
    }
    public void resetPosition(){
        pinpoint.resetPosAndIMU();
    }
    public void setPosition(Pose2D position){pinpoint.setPosition(position);}

    public void resetIMU(){
        pinpoint.recalibrateIMU();
    }
    public Pose2D getVelocity(){
        return pinpoint.getVelocity();
    }
    public Pose2D getOffset(){
        return new Pose2D(pinpoint.getXOffset(DistanceUnit.INCH),
                          pinpoint.getYOffset(DistanceUnit.INCH),
                          pinpoint.getHeadingOffset(AngleUnit.DEGREES));}
    public void setOffset(Pose2D offset){}
    public void setPodOffsets(double xOffset, double yOffset) {
        pinpoint.setPodOffsets(xOffset, yOffset, DistanceUnit.MM);
    }
    public Pose2D getRelativePosition(Pose2D reference){
        return getPosition().subtract(reference);
    }
    public void setRelativePosition(Pose2D position, Pose2D reference){
        pinpoint.setPosition(position.add(reference));
    }
    public void statusTelemetry() {
            /*
            Gets the Pinpoint device status. Pinpoint can reflect a few states. But we'll primarily see
            READY: the device is working as normal
            CALIBRATING: the device is calibrating and outputs are put on hold
            NOT_READY: the device is resetting from scratch. This should only happen after a power-cycle
            FAULT_NO_PODS_DETECTED - the device does not detect any pods plugged in
            FAULT_X_POD_NOT_DETECTED - The device does not detect an X pod plugged in
            FAULT_Y_POD_NOT_DETECTED - The device does not detect a Y pod plugged in
            FAULT_BAD_READ - The firmware detected a bad I²C read, if a bad read is detected, the device status is updated and the previous position is reported
            */
            telemetry.addData("Status", pinpoint.getDeviceStatus());
            telemetry.addData("Pinpoint Frequency", pinpoint.getFrequency()); //prints/gets the current refresh rate of the Pinpoint
    }
    public void positionTelemetry(){
        telemetry.addData("Position: ", getPosition());
    }
}