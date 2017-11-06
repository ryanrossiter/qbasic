package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.AccountManager;
import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

//DeleteAcctCommand handles the deleteacct command, it takes an account number and name.
public class DeleteAcctCommand implements Command {

    public String getCommandString() {
        return "deleteacct";
    }


    public boolean invoke(String accountType) {
        // Shouldn't be accessible from machine mode
        if (accountType.equals("machine")) {
            System.out.println("Command only available when in agent mode.");
            return false;
        }

        int accNumber = Input.PromptForAccountNumber("Enter the account number you want to delete: ");
        if (accNumber == -1) {
            return false;
        } else if (AccountManager.Exists(accNumber) == false) {
            System.out.println("Account number is invalid.");
            return false;
        }

        String accName = Input.PromptForAccountName("Enter the name of the account you want to delete: ");
        if (accName == null) {
            return false;
        }

        TransactionSummarizer.RecordTransaction("DEL", accNumber, null, null, accName);
        AccountManager.Delete(accNumber);

        return false;
    }
}
