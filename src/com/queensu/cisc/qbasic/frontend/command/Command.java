package com.queensu.cisc.qbasic.frontend.command;

public interface Command {
    String getCommandString();

    boolean invoke(String accountType);
}
