package com.queensu.cisc.qbasic.frontend.command;

public class DepositCommand implements Command {
    public String COMMAND_STRING = "deposit";

    public boolean invoke(String[] params) {
        return false;
    }
}
