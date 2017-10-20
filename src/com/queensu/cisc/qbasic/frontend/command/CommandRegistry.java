package com.queensu.cisc.qbasic.frontend.command;

import java.util.HashMap;
import java.util.Map;
//A Command Registry holds data about whether it is in agent mode or machine mode, and holds information about which
//commands are available to that mode. Also checks for permission when a request is sent.
public class CommandRegistry {
    private Map<String, Command> commands = new HashMap<>();
    private String accountType = null;

    public CommandRegistry(String accountType) {
        this.accountType = accountType;
    }

    public void registerCommand(Command c) {
        //System.out.println("Registered: " + c.getCommandString());
        commands.putIfAbsent(c.getCommandString(), c);
    }

    public boolean invokeCommand(String commandString, String[] params) {
        if (commands.containsKey(commandString) == true) {
            return commands.get(commandString).invoke(accountType);
        } else {
            System.out.println("Command \"" + commandString + "\" not recognized.");
        }

        return false;
    }
}
