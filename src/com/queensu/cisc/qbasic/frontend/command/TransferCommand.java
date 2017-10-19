package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

public class TransferCommand implements Command {

    public String getCommandString() {
        return "transfer";
    }

    public boolean invoke(String accountType) {
        int accNum1 = Input.PromptForAccountNumber("Enter an account number to withdraw from: ");
        int accNum2 = Input.PromptForAccountNumber("Enter an account number to deposit into: ");
        int amount = Input.PromptForAmount(accountType, "Enter an amount to transfer: ");

        TransactionSummarizer.RecordTransaction("XFR", accNum1, amount, accNum2, null);

        return false;
    }
}
