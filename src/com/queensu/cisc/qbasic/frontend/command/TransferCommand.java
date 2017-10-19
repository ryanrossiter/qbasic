package com.queensu.cisc.qbasic.frontend.command;

public class TransferCommand implements Command {
    public String COMMAND_STRING = "transfer";

    public boolean invoke(String accountType) {
        return false;
    }
}
