package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.AccountManager;
import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
//DepositCommand handles the deposit command.
public class DepositCommand implements Command {

    public String getCommandString() {
        return "deposit";
    }
    //Calls Input to get information, then adds it to TransactionSummary.
    public boolean invoke(String accountType) {
        int accNum = Input.PromptForAccountNumber();
        if (accNum == -1) {
            return false;
        } else if (AccountManager.Exists(accNum) == false) {
            System.out.println("Account number is invalid.");
            return false;
        }

        int amount = Input.PromptForAmount(accountType, "Enter an amount to deposit: ");
        if (amount == -1) {
            return false;
        }

        TransactionSummarizer.RecordTransaction("DEP", accNum, amount, null, null);
        return false;
    }
}
