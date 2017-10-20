package com.queensu.cisc.qbasic.frontend;

import com.queensu.cisc.qbasic.frontend.command.CommandRegistry;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner( System.in );

    public static void main(String[] params) {
        AccountManager.Initialize("accounts.txt");

        boolean loop = true;
        boolean logged_in = false;

        while (loop) {
            CommandRegistry commandRegistry = null;

            while (!logged_in) {
                String input = scanner.nextLine();
                commandRegistry = Login.Verify(input);
                if (commandRegistry != null) {
                    logged_in = true;
                }
            }

            TransactionSummarizer.Initialize(String.format("tsf-%d.txt", System.currentTimeMillis()));

            while (logged_in) {
                String input = scanner.nextLine();
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