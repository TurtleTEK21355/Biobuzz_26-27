package org.firstinspires.ftc.teamcode.command;


import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.teamcode.robot.subsystem.Gates;

public class GatesOpen extends Command {
    Gates gates;
    public GatesOpen(Gates gates) { this.gates = gates; }

    @Override
    public void init() { gates.open(); }

    @Override
    public boolean isCompleted() { return (true); }
}