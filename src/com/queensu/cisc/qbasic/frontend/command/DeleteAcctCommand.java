package com.queensu.cisc.qbasic.frontend.command;

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
        String accName = Input.PromptForAccountName("Enter the name of the account you want to delete: ");

        TransactionSummarizer.RecordTransaction("DEL", accNumber, null, null, accName);

        return false;
    }
}
