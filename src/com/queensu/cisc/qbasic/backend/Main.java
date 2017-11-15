package com.queensu.cisc.qbasic.backend;

import java.io.*;

// This main class is intended to be run by the qbasic script
// In the zip file this script is located at the root directory (sh and bat scripts for linux and windows respectively)
// Usage of the qbasic script: qbasic <account-filename> <transaction-summary-filename>

//Main Class waits for a user to login, then keeps them in a loop which handles commands, upon logout, the main class will start
//over and wait for another login.
public class Main {
    public static void exit() {
        System.out.close();
        System.exit(0);
    }

    public static void main(String[] params) {
        if (params.length < 4) {
            System.out.println("usage: back-office <merged tsf> <old maf> <new maf> <new vaf>");
            return;
        }

        String transactionSummaryFilename = params[0];
        String masterAccountFilename = params[1];
        String newMasterAccountFilename = params[2];
        String newValidAccountFilename = params[3];

        //Starts up the Valid Account File, using the input from running the program: accountFilename
        AccountManager.Initialize(masterAccountFilename);
        TransactionSummaryProcessor.ProcessTransactions(transactionSummaryFilename);
        AccountManager.GenerateNewMasterAccountsFile(newMasterAccountFilename);
        AccountManager.GenerateNewValidAccountsFile(newValidAccountFilename);

        Main.exit();
    }


}