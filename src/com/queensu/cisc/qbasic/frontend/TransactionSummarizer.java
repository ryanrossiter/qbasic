package com.queensu.cisc.qbasic.frontend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TransactionSummarizer {
    private static boolean initialized = false;
    private static PrintWriter outputStream = null;

    public static void Initialize(String outputFile) {
        try {
            outputStream = new PrintWriter(new FileWriter(outputFile));
            initialized = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Destroy() {
        if (outputStream != null) {
            outputStream.close();
            initialized = false;
        }
    }

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

        outputStream.println(transaction);
    }
}
