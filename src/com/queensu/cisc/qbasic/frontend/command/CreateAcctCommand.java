package com.queensu.cisc.qbasic.frontend.command;

public class CreateAcctCommand implements Command {
    public String COMMAND_STRING = "createacct";

    public boolean invoke(String accountType) {
        return false;
    }
}
