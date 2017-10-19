package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

public class DepositCommand implements Command {

    public String getCommandString() {
        return "deposit";
    }

    public boolean invoke(String accountType) {
        int accNum = Input.PromptForAccountNumber();
        int amount = Input.PromptForAmount(accountType, "Enter an amount to deposit: ");

        TransactionSummarizer.RecordTransaction("DEP", accNum, amount,null,null);

        return false;
    }
}
