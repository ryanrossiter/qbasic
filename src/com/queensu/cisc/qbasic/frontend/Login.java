package com.queensu.cisc.qbasic.frontend;

import com.queensu.cisc.qbasic.frontend.command.CommandRegistry;
import com.queensu.cisc.qbasic.frontend.command.CommandRegistryFactory;
//The login class handles the login command, and determines whether the session will be an agent or machine session
public class Login {
    //Verify takes a string and determines whether to start an agent or machine session
     public static CommandRegistry verify(String input){
        if (input.equals("login agent")) {
            return CommandRegistryFactory.CreateAgentCommandRegistry();
        }
        else if (input.equals("login agent")) {
            return CommandRegistryFactory.CreateAgentCommandRegistry();
        }
        else {
            return null;
        }
     }
 }