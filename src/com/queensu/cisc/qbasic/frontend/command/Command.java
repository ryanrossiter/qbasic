package com.queensu.cisc.qbasic.frontend.command;

public interface Command {
    String COMMAND_STRING = null;

    void invoke(String[] params);
}
