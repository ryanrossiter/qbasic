package com.queensu.cisc.qbasic.frontend.command;

import com.queensu.cisc.qbasic.frontend.AccountManager;
import com.queensu.cisc.qbasic.frontend.Input;
import com.queensu.cisc.qbasic.frontend.TransactionSummarizer;
//CreateAcctCommand handles the create acct command
public class CreateAcctCommand implements Command {

    public String getCommandString() {
        return "createacct";
    }
    //Double checks to make sure that it is not in machine mode, then asks for Input and adds to Transaction Summary
    public boolean invoke(String accountType) {
        // Shouldn't be accessible from machine mode
        if (accountType.equals("machine")) {
            System.out.println("Command only available when in agent mode.");
            return false;
        }

        int accNum = Input.PromptForAccountNumber();
        if (accNum == -1) {
            return false;
        } else if (AccountManager.Exists(accNum) == true) {
            System.out.println("Account number must not already exist.");
            return false;
        }

        String accountName = Input.PromptForAccountName();
        if (accountName == null) {
            return false;
        }

        TransactionSummarizer.RecordTransaction("NEW", accNum, null,null,accountName);

        return false;
    }
}
