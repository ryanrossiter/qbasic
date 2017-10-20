package com.queensu.cisc.qbasic.frontend.command;
//A command has 2 methods, it has a getCommandString which returns the type of command that it is in a string,
//and the invoke function which takes the required input, adds it to the transaction summary file, and then returns false,
//The only command which returns true is logout, which would then break the logged in loop in Main.Java.
public interface Command {
    String getCommandString();

    boolean invoke(String accountType);
}
