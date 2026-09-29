package org.firstinspires.ftc.teamcode.library.sensor.localization;

import org.firstinspires.ftc.teamcode.library.internal.Pose2D;

public interface Localizer {
    Pose2D getOffset();
    void setOffset(Pose2D offset);
    Pose2D getPosition();
    void setPosition(Pose2D position);
    void resetPosition();
    Pose2D getRelativePosition(Pose2D reference);
    void setRelativePosition(Pose2D position, Pose2D reference);
}
