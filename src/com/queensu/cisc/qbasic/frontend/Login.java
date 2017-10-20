package com.queensu.cisc.qbasic.frontend;

import com.queensu.cisc.qbasic.frontend.command.CommandRegistry;
import com.queensu.cisc.qbasic.frontend.command.CommandRegistryFactory;

public class Login {
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