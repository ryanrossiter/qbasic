package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

public class DeleteAcctCommand implements Command {

    public String getCommandString() {
        return "deleteacct";
    }

    public boolean invoke(String accountType) {
        int accNumber = Input.PromptForAccountNumber("Enter the account number you want to delete: ");
        String accName = Input.PromptForAccountName("Enter the name of the account you want to delete: ");

        TransactionSummarizer.RecordTransaction("DEL", accNumber, null, null, accName);

        return false;
    }
}
