package com.queensu.cisc.qbasic.frontend;

import com.queensu.cisc.qbasic.frontend.command.CommandRegistry;
import com.queensu.cisc.qbasic.frontend.command.CommandRegistryFactory;
//The login class handles the login command, and determines whether the session will be an agent or machine session
public class Login {
    //Verify takes a string and determines whether to start an agent or machine session
     public static CommandRegistry Verify(String input){
        if (input.equals("login agent")) {
            System.out.println("Logged in as an agent user.");
            return CommandRegistryFactory.CreateAgentCommandRegistry();
        } else if (input.equals("login machine")) {
            System.out.println("Logged in as a machine user.");
            return CommandRegistryFactory.CreateMachineCommandRegistry();
        } else {
            return null;
        }
     }
 }