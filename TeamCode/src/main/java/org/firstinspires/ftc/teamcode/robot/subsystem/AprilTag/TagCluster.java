package org.firstinspires.ftc.teamcode.robot.subsystem.AprilTag;

import org.firstinspires.ftc.libcode.library.internal.Pose2D;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The back is the side where the hive can be shot into at the beginning,
 * and the front is the opposite side.
 */
public enum TagCluster {
    FRONT(
            new Tag(new Pose2D(-19.2855,-12.8775,90), 38, 30),
            new Tag(new Pose2D(-15.5355,-12.8775,90), 39, 31),
            new Tag(new Pose2D(-10.0355,-12.8775,90), 40, 32),
            new Tag(new Pose2D(-6.2855,-12.8775,90), 41, 33)
    ),
    BACK(
            new Tag(new Pose2D(-6.2855,12.8775,270), 42, 34),
            new Tag(new Pose2D(-10.0355,12.8775,270), 43, 35),
            new Tag(new Pose2D(-15.5355,12.8775,270), 44, 36),
            new Tag(new Pose2D(-19.2855,12.8775,270), 45, 37)
    );

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
