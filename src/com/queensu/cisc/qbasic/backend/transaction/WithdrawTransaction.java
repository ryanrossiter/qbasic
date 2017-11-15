package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//Handles the withdraw transaction, receives input from TransactionRegistry.java.
public class WithdrawTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "WDR";
    }

    // Withdraws amount from the account associated with accountNum0
    @Override
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Account acc = AccountManager.GetAccount(accountNum0);
        if (acc == null) {
            System.out.println("Account number " + accountNum0 + " does not exist.");
        } else {
            acc.setBalance(acc.getBalance() - amount);
        }
    }
}
