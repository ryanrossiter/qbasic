package com.queensu.cisc.qbasic.frontend;

import com.queensu.cisc.qbasic.frontend.command.CommandRegistry;
import com.queensu.cisc.qbasic.frontend.command.CommandRegistryFactory;

public class Login {
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