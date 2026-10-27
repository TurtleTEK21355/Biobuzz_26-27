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
            new Tag(new Pose2D(52.7145,59.1225,90), 38, 30),
            new Tag(new Pose2D(56.4645,59.1225,90), 39, 31),
            new Tag(new Pose2D(61.9645,59.1225,90), 40, 32),
            new Tag(new Pose2D(65.7145,59.1225,90), 41, 33)
    ),
    BACK(
            new Tag(new Pose2D(65.7145,84.8775,270), 42, 34),
            new Tag(new Pose2D(61.9645,84.8775,270), 43, 35),
            new Tag(new Pose2D(56.4645,84.8775,270), 44, 36),
            new Tag(new Pose2D(52.7145,84.8775,270), 45, 37)
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
