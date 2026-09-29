package org.firstinspires.ftc.teamcode.library.commandsinternal;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandList extends ArrayList<Command>{
    public CommandList(Command... commands) {
        addAll(Arrays.asList(commands));
    }
}
