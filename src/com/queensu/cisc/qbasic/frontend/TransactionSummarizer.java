package com.queensu.cisc.qbasic.frontend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//The Transaction Summarizer is responsible for generating the transaction summary, and starting a new one.
public class TransactionSummarizer {
    private static boolean initialized = false;
    private static PrintWriter outputStream = null;
    //Initialize creates a new transaction summary.
    public static void Initialize(String outputFile) {
        try {
            outputStream = new PrintWriter(new FileWriter(outputFile));
            initialized = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Writes the transaction summary file, and sets initialized false so that a new one will be initialized.
    public static void Destroy() {
        if (outputStream != null) {
            outputStream.println("EOS"); // write transaction summary file ending
            outputStream.close();
            initialized = false;
        }
    }
    //Checks if there is a Valid Transaction File, creates one if there isn't, then adds a line to it.
    public static void RecordTransaction(String transactionCode, Integer ac1, Integer cents, Integer ac2, String accountName) {
        // assume all transaction data is already validated

        if (initialized == false) {
            System.out.println("TransactionSummarizer not initialized.");
        }

        if (ac1 == null) {
            ac1 = 0;
        }

        String s_cents = "000";
        if (cents != null) {
            s_cents = String.valueOf(cents);
        }

        if (ac2 == null) {
            ac2 = 0;
        }

        if (accountName == null) {
            accountName = "***";
        }

        String transaction = String.format("%s %07d %s %07d %s",
            transactionCode,
            ac1,
            s_cents,
            ac2,
            accountName
        );

        System.out.println("Recorded transaction: " + transaction);

        outputStream.println(transaction);
    }
}
