package org.firstinspires.ftc.teamcode.robot.subsystem.AprilTag;

import org.firstinspires.ftc.libcode.library.internal.Pose2D;

public class Tag {
    private final Pose2D position;
    private final int idRed;
    private final int idBlue;

    public Tag(Pose2D position, int idRed, int idBlue) {
        this.position = position;
        this.idRed = idRed;
        this.idBlue = idBlue;
    }

    public Pose2D getPosition() {
        return position;
    }
    public int getId(AllianceSide side) {
        if (side == AllianceSide.BLUE) return idBlue;
        else return idRed;
    }
}
