package org.firstinspires.ftc.teamcode.robot.subsystem.AprilTag;

import org.firstinspires.ftc.libcode.library.internal.Pose2D;

public class Tag {
    private Pose2D position;
    private int id;

    public Tag(Pose2D position, int id) {
        this.position = position;
        this.id = id;
    }

    public Pose2D getPosition() {
        return position;
    }
    public int getId() {
        return id;
    }
    public void setPosition(Pose2D position) {
        this.position = position;
    }
    public void setId(int id) {
        this.id = id;
    }
}
