package com.queensu.cisc.qbasic.frontend.command;

public class DeleteAcctCommand implements Command {

    public String getCommandString() {
        return "deleteacct";
    }

    public boolean invoke(String accountType) {
        return false;
    }
}
