package com.queensu.cisc.qbasic.frontend;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TransactionSummarizer {
    private PrintWriter outputStream = null;

    public TransactionSummarizer(String outputFile) {
        try {
            outputStream = new PrintWriter(new FileWriter(outputFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public void recordTransaction(String transactionCode, int ac1, int cents, int ac2, String accountName) {
        
    }
}
