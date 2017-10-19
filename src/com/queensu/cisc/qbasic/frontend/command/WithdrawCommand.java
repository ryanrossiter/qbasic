package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

public class WithdrawCommand implements Command {

    public String getCommandString() {
        return "withdraw";
    }

    public boolean invoke(String accountType) {
        int accNum = Input.PromptForAccountNumber();
        int amount = Input.PromptForAmount(accountType, "Enter an amount to withdraw: ");

        TransactionSummarizer.RecordTransaction("WDR", accNum, amount, null,null);

        return false;
    }
}