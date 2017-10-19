package com.queensu.cisc.qbasic.frontend.command;

public class LogoutCommand implements Command {

    public String getCommandString() {
        return "logout";
    }

    public boolean invoke(String accountType) {
        return true; // Send logout flag
    }
}
