package com.queensu.cisc.qbasic.frontend.command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private Map<String, Command> commands = new HashMap<>();

    public void registerCommand(Command c) {
        commands.putIfAbsent(c.COMMAND_STRING, c);
    }

    public boolean invokeCommand(String commandString, String[] params) {
        if (commands.containsKey(commandString) == true) {
            return commands.get(commandString).invoke(params);
        } else {
            System.out.println("Command \"" + commandString + "\" not recognized.");
        }

        return false;
    }
}
