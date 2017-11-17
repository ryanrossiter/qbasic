package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//Handles the transfer transaction, receives input from TransactionRegistry.jav
public class TransferTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "XFR";
    }

    // Gets the accounts associated with accountNum0 and accountNum1 and performs the transfer operation
    // from account0 to account1
    @Override
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Account acc0 = AccountManager.GetAccount(accountNum0);
        AccountManager.Account acc1 = AccountManager.GetAccount(accountNum1);

        if (acc0 == null) {
            System.out.println("Account number " + accountNum0 + " does not exist.");
        } else if (acc1 == null) {
            System.out.println("Account number " + accountNum1 + " does not exist.");
        } else {
            boolean success = acc0.setBalance(acc0.getBalance() - amount);
            if (success) {
                acc1.setBalance(acc1.getBalance() + amount);
            }
        }
    }
}
