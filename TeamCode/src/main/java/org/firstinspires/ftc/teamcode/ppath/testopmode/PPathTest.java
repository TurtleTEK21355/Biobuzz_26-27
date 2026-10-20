package org.firstinspires.ftc.teamcode.ppath.testopmode;

import static com.pedropathing.api.Paths.curve;
import static com.pedropathing.api.Paths.line;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.ppath.PPConstants;

@Autonomous(name = "PPath Test", group = "Autonomous")
public class PPathTest extends LinearOpMode {

    private Follower follower;

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(59, 9, 90);
    private final Pose path1 = poseFactory.of(23.3217, 9, 180);
    private final Pose path1Control1 = poseFactory.of(44.6524, 17.1, 0);
    private final Pose point2 = poseFactory.of(8, 9, 180);
    private final Pose point3 = poseFactory.of(19.8119, 24.844, 180);
    private final Pose point4 = poseFactory.of(9.0357, 95.3798, 90);
    private final Pose point4Control1 = poseFactory.of(23.3475, 64.2702, 0);

    // Autonomous routine
    public Command autoRoutine() {
        return sequential(
                follow(follower, path1()),
                follow(follower, path2()),
                follow(follower, path3()),
                follow(follower, path4())
        );
    }

    @Override
    public void runOpMode() {
        Scheduler.reset();
        follower = PPConstants.create(hardwareMap);
        follower.setPose(start);
        follower.update();

        waitForStart();
        schedule(autoRoutine());

        while (opModeIsActive()) {
            follower.update();
            Scheduler.execute();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());

            if (follower.currentPath() != null) {
                telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
                telemetry.addData("Path number", follower.pathIndex());
            }

            telemetry.update();
        }
    }

    public Path path1() {
        return curve(start, path1Control1, path1).linear(start, path1);
    }

    public Path path2() {
        return line(path1, point2).tangent();
    }

    public Path path3() {
        return line(point2, point3).constant(point3);
    }

    public Path path4() {
        return curve(point3, point4Control1, point4).linear(point3, point4);
    }
}
