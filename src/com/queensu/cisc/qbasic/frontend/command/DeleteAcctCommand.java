package com.queensu.cisc.qbasic.frontend.command;

public class DeleteAcctCommand implements Command {
    public String COMMAND_STRING = "deleteacct";

    public boolean invoke(String[] params) {
        return false;
    }
}