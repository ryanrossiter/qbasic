package com.queensu.cisc.qbasic.frontend;

import com.queensu.cisc.qbasic.frontend.command.CommandRegistry;

import java.util.Arrays;
import java.util.Scanner;

// This main class is intended to be run by the qbasic script
// In the zip file this script is located at the root directory (sh and bat scripts for linux and windows respectively)
// Usage of the qbasic script: qbasic <account-filename> <transaction-summary-filename>

//Main Class waits for a user to login, then keeps them in a loop which handles commands, upon logout, the main class will start
//over and wait for another login.
public class Main {
    public static void main(String[] params) {
        if (params.length < 2) {
            System.out.println("usage: qbasic <account-filename> <transaction-summary-filename>");
            return;
        }

        String accountFilename = params[0];
        String transactionSummaryFilename = params[1];
        //Starts up the Valid Account File, using the input from running the program: accountFilename
        AccountManager.Initialize(accountFilename);

        boolean loop = true;
        boolean logged_in = false;

        while (loop) {
            CommandRegistry commandRegistry = null;

            while (!logged_in) {
                String input = Input.PromptForInput();
                commandRegistry = Login.Verify(input);
                if (commandRegistry != null) {
                    logged_in = true;
                }
            }

            TransactionSummarizer.Initialize(transactionSummaryFilename); //String.format("tsf-%d.txt", System.currentTimeMillis()));

            while (logged_in) {
                String input = Input.PromptForInput();
                String[] cmd = input.split(" ");
                String[] parameters = Arrays.copyOfRange(cmd, 1, cmd.length);
                boolean logout = commandRegistry.invokeCommand(cmd[0], parameters);
                if (logout){
                    logged_in = false;
                }
            }

            TransactionSummarizer.Destroy();
        }
     }
 }