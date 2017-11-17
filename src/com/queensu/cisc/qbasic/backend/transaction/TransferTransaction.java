package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//Handles the transfer transaction, receives input from TransactionRegistry.jav
public class TransferTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "XFR";
    }

    @Override
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Account acc0 = AccountManager.GetAccount(accountNum0);
        AccountManager.Account acc1 = AccountManager.GetAccount(accountNum1);

        if (acc0 == null) {
            // err
        } else if (acc1 == null) {
            // err
        } else {
            boolean success = acc0.setBalance(acc0.getBalance() - amount);
            if (success) {
                acc1.setBalance(acc1.getBalance() + amount);
            }
        }
    }
}
