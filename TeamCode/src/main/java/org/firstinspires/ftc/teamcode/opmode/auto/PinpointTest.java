package org.firstinspires.ftc.teamcode.opmode.auto;

//import com.bylazar.configurables.annotations.Configurable;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.libcode.library.internal.Pose2D;
import org.firstinspires.ftc.libcode.library.internal.telemetry.TelemetryPasser;
import org.firstinspires.ftc.teamcode.robot.Sting;

//@Configurable
@Autonomous(name= "Pinpoint Test", group = "auto")
public class PinpointTest extends LinearOpMode {
    //Robot Start

    Sting robot;

    public void initialize() {
        TelemetryPasser.telemetry = telemetry;
        robot = Sting.build(hardwareMap);
        sleep(500);
        robot.getPinpoint().setPosition(new Pose2D(9, 84, -90));
        sleep(300);
        robot.getPinpoint().positionTelemetry();
        telemetry.update();

    }

    public void runOpMode() {
        initialize();
        waitForStart();
        while(opModeIsActive()) {
            robot.getPinpoint().positionTelemetry();
            telemetry.update();
        }
    }
}
