package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
//TransferCommand handles the transfer command.
public class TransferCommand implements Command {

    public String getCommandString() {
        return "transfer";
    }
//invoke calls Input Multiple times to get the requisite information, then adds the information to the TransactionSummarizer.
    public boolean invoke(String accountType) {
        int accNum1 = Input.PromptForAccountNumber("Enter an account number to withdraw from: ");
        int accNum2 = Input.PromptForAccountNumber("Enter an account number to deposit into: ");
        int amount = Input.PromptForAmount(accountType, "Enter an amount to transfer: ");

        TransactionSummarizer.RecordTransaction("XFR", accNum1, amount, accNum2, null);

        return false;
    }
}
