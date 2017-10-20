package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
//WithdrawCommand handles the withdraw command.
public class WithdrawCommand implements Command {
    private static int MAX_WITHDRAW_AMOUNT = 100000;
    private int withdrawTotal = 0; // machine user per-session withdraw total

    public String getCommandString() {
        return "withdraw";
    }
    //invoke is given an account type to tell what the limit for withdrawl is.
    public boolean invoke(String accountType) {
        int accNum = Input.PromptForAccountNumber();
        int amount = Input.PromptForAmount(accountType, "Enter an amount to withdraw: ");

        if (withdrawTotal >= WithdrawCommand.MAX_WITHDRAW_AMOUNT) {
            System.out.println("A maximum of $1,000 can be withdrawn in an ATM session.");
            return false;
        }
        withdrawTotal += amount;

        TransactionSummarizer.RecordTransaction("WDR", accNum, amount, null,null);

        return false;
    }
}