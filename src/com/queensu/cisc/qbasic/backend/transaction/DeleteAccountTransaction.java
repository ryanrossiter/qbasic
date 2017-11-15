package com.queensu.cisc.qbasic.backend.transaction;

import com.queensu.cisc.qbasic.backend.AccountManager;
//Handles the delete account transaction, receives input from Transaction Registry.java
public class DeleteAccountTransaction implements Transaction {

    @Override
    public String getTransactionString() {
        return "DEL";
    }

    @Override
    //Deletes the specified account.
    public void processTransaction(int accountNum0, int amount, int accountNum1, String accountName) {
        AccountManager.Delete(accountNum0, accountName);
    }
}
