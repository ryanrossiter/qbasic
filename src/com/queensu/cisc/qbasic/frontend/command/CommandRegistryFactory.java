package com.queensu.cisc.qbasic.frontend.command;

public class CommandRegistryFactory {
    // Creates command registry for machine users
    public static CommandRegistry CreateMachineCommandRegistry() {
        CommandRegistry cr = new CommandRegistry("machine");
        cr.registerCommand(new LogoutCommand());
        cr.registerCommand(new WithdrawCommand());
        cr.registerCommand(new DepositCommand());
        cr.registerCommand(new TransferCommand());
        return cr;
    }

    // Creates command registry for agent users
    public static CommandRegistry CreateAgentCommandRegistry() {
        CommandRegistry cr = new CommandRegistry("agent");
        cr.registerCommand(new LogoutCommand());
        cr.registerCommand(new WithdrawCommand());
        cr.registerCommand(new DepositCommand());
        cr.registerCommand(new TransferCommand());
        cr.registerCommand(new CreateAcctCommand());
        cr.registerCommand(new DeleteAcctCommand());
        return cr;
    }
}
