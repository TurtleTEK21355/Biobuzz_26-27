package org.firstinspires.ftc.teamcode.examples.command;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.library.commandsinternal.Command;
import org.firstinspires.ftc.teamcode.library.internal.telemetry.TelemetryString;

public class TimerCommand extends Command {
    private ElapsedTime timer = new ElapsedTime();
    private int milliseconds;
    public String dataKey = "TimerCommand";


    public TimerCommand(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void init() {
        timer.reset();
    }

    @Override
    public String telemetry() {
        TelemetryString string = new TelemetryString();
        string.addData("Remaining Timer Time:", milliseconds - timer.milliseconds());
        return string.toString();
    }

    @Override
    public boolean isCompleted() {
        return timer.milliseconds() >= milliseconds;
    }

}
