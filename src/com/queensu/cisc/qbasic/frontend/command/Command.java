package com.queensu.cisc.qbasic.frontend.command;

public interface Command {
    String COMMAND_STRING = null;

    boolean invoke(String accountType);
}
