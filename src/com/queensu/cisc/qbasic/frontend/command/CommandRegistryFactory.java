package com.queensu.cisc.qbasic.frontend.command;

public class CommandRegistryFactory {
    // Creates command registry for machine users
    public static CommandRegistry createMachineCommandRegistry() {
        CommandRegistry cr = new CommandRegistry();
        cr.registerCommand(new WithdrawCommand());
        //cr.registerCommand(new DepositCommand());
        //cr.registerCommand(new TransferCommand());
        return cr;
    }

    // Creates command registry for agent users
    public static CommandRegistry createAgentCommandRegistry() {
        CommandRegistry cr = CommandRegistryFactory.createMachineCommandRegistry();
        //cr.registerCommand(new CreateAcctCommand());
        //cr.registerCommand(new DeleteAcctCommand());
        return cr;
    }
}
