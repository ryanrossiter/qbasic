package com.queensu.cisc.qbasic.backend;

import com.queensu.cisc.qbasic.backend.transaction.TransactionRegistry;

import java.io.*;

public class TransactionSummaryProcessor {
    public static void ProcessTransactions(String transactionSummaryFilename) {
        TransactionRegistry transactionRegistry = new TransactionRegistry();
        BufferedReader inputStream = null;
        int transactionCount = 0;

        try {
            inputStream = new BufferedReader(new FileReader(transactionSummaryFilename));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Can't load transactionSummaryFile with FileReader, trying as resource.");
            try {
                inputStream = new BufferedReader(new InputStreamReader(AccountManager.class.getResourceAsStream("/" + transactionSummaryFilename)));
            } catch (Exception ee) {
                System.out.println("Failed to load transactionSummaryFilename.");
                Main.exit();
                return;
            }
        }

        try {
            String line;
            while ((line = inputStream.readLine()) != null && line.equals("EOS") == false) {
                try {
                    String[] items = line.split(" ", 5);
                    String transactionID = items[0];
                    Integer accountNum0 = Integer.valueOf(items[1]);
                    Integer amount = Integer.valueOf(items[2]);
                    Integer accountNum1 = Integer.valueOf(items[3]);
                    String accountName = items[4];

                    transactionRegistry.processTransaction(transactionID, accountNum0, amount, accountNum1, accountName);
                    transactionCount++;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Processed " + transactionCount + " transactions.");
    }
}
