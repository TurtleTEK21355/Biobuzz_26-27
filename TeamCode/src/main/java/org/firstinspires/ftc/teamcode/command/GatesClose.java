package org.firstinspires.ftc.teamcode.command;


import org.firstinspires.ftc.libcode.library.commandsinternal.Command;
import org.firstinspires.ftc.teamcode.robot.subsystem.Gates;

public class GatesClose extends Command {
    Gates gates;
    public GatesClose(Gates gates) { this.gates = gates; }

    @Override
    public void init() { gates.closeGates(); }

    @Override
    public boolean isCompleted() { return (true); }
}