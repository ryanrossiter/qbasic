package com.queensu.cisc.qbasic.frontend.command;
//Logout Command handles the logout command
public class LogoutCommand implements Command {

    public String getCommandString() {
        return "logout";
    }
    //invoke is called when logout is typed, it returns true to the Main Loop, indicating that it should return to
    //the top of the Main loop, and then the login loop.
    public boolean invoke(String accountType) {
        return true; // Send logout flag
    }
}
