package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;

public class CreateAcctCommand implements Command {

    public String getCommandString() {
        return "createacct";
    }

    public boolean invoke(String accountType) {
        // Shouldn't be accessible from machine mode
        if (accountType.equals("machine")) {
            System.out.println("Command only available when in agent mode.");
            return false;
        }

        int accNum = Input.PromptForAccountNumber();
        String accountName = Input.PromptForAccountName();

        TransactionSummarizer.RecordTransaction("NEW", accNum, null,null,accountName);

        return false;
    }
}
