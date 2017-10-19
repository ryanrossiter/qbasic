package com.queensu.cisc.qbasic.frontend.command;

public class LogoutCommand implements Command {
    public String COMMAND_STRING = "logout";

    public boolean invoke(String[] params) {
        return true; // Send logout flag
    }
}
