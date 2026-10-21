package org.firstinspires.ftc.teamcode.robot.subsystem.AprilTag;

import org.firstinspires.ftc.libcode.library.internal.Pose2D;

import java.util.ArrayList;
import java.util.Arrays;

public enum TagCluster {
    ;
//    RED_FRONT(),
//    RED_BACK(),
//    BLUE_FRONT(),
//    BLUE_BACK();

    private final Tag firstTag;
    private final Tag secondTag;
    private final Tag thirdTag;
    private final Tag fourthTag;


    TagCluster(Tag firstTag, Tag secondTag, Tag thirdTag, Tag fourthTag) {
        this.firstTag = firstTag;
        this.secondTag = secondTag;
        this.thirdTag = thirdTag;
        this.fourthTag = fourthTag;
    }
    public ArrayList<Tag> getTags() {
        return new ArrayList<Tag>(Arrays.asList(firstTag, secondTag, thirdTag, fourthTag));
    }
}
