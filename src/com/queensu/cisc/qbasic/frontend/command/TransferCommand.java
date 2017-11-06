package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.AccountManager;
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
        if (accNum1 == -1) {
            return false;
        } else if (AccountManager.Exists(accNum1) == false) {
            System.out.println("Account number is invalid.");
            return false;
        }

        int accNum2 = Input.PromptForAccountNumber("Enter an account number to deposit into: ");
        if (accNum2 == -1) {
            return false;
        } else if (AccountManager.Exists(accNum2) == false) {
            System.out.println("Account number is invalid.");
            return false;
        }

        int amount = Input.PromptForAmount(accountType, "Enter an amount to transfer: ");
        if (amount == -1) {
            return false;
        }

        TransactionSummarizer.RecordTransaction("XFR", accNum1, amount, accNum2, null);

        return false;
    }
}
