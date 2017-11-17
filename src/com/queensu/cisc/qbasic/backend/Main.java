package com.queensu.cisc.qbasic.backend;

import java.io.*;

/*
    This main class is intended to be run by the back-office script
    In the zip file this script is located at the root directory (sh and bat scripts for linux and windows respectively)
    Usage of the back-office script: back-office <merged tsf> <old maf> <new maf> <new vaf>

    Main class will verify that the required parameters are provided, initialize the AccountManager,
    invoke the TransactionSummaryProcessor, and then have the AccountManager generate the output files
*/
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

        // Starts up the AccountManager, using the masterAccountFilename provided as input
        AccountManager.Initialize(masterAccountFilename);

        // Invoke the TransactionSummaryProcessor to process transactions from the transactionSummaryFilename
        TransactionSummaryProcessor.ProcessTransactions(transactionSummaryFilename);

        // Use the AccountManager to generate the output files with filenames
        // provided by newMasterAccountFilename and newValidAccountFilename
        AccountManager.GenerateNewMasterAccountsFile(newMasterAccountFilename);
        AccountManager.GenerateNewValidAccountsFile(newValidAccountFilename);

        Main.exit();
    }


}