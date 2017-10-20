package com.queensu.cisc.qbasic.frontend;

import java.util.Scanner;

public class Input {
    // Max transaction amount for machine and agent account types
    private static int MAX_AMOUNT_MACHINE = 100000;
    private static int MAX_AMOUNT_AGENT = 99999999;

    private static Scanner scanner = new Scanner(System.in);

    public static int PromptForAccountNumber() {
        return Input.PromptForAccountNumber("Enter a valid account number: ");
    }

    public static int PromptForAccountNumber(String prompt) {
        Integer accNum = null;
        while (accNum == null) {
            System.out.print(prompt);
            try {
                accNum = scanner.nextInt();
            } catch (Exception e) {}

            if (AccountManager.Exists(accNum) == false) {
                System.out.println("Account number is invalid.");
                accNum = null;
            }
        }

        return accNum;
    }

    public static int PromptForAmount(String accountType) {
        return Input.PromptForAmount(accountType, "Enter an amount in cents: ");
    }

    public static int PromptForAmount(String accountType, String prompt) {
        int max_amount = 0;
        if (accountType == "machine") {
            max_amount = MAX_AMOUNT_MACHINE;
        } else if (accountType == "agent") {
            max_amount = MAX_AMOUNT_AGENT;
        }

        Integer amount = null;
        while (amount == null) {
            System.out.print(prompt);
            try {
                amount = scanner.nextInt();
            } catch (Exception e) {}

            if (amount != null) {
                if (amount > max_amount) {
                    System.out.println(String.format("Value must be less than %d.", max_amount));
                    amount = null;
                } else if (amount < 0) {
                    System.out.println("Value must be positive.");
                    amount = null;
                }
            }
        }

        return amount;
    }

    public static String PromptForAccountName() {
        return Input.PromptForAccountName("Enter an Account Name: ");
    }

    public static String PromptForAccountName(String prompt) {
        String accountName = null;
        while (accountName == null) {
            System.out.print(prompt);
            try {
                accountName = scanner.nextLine();
            } catch (Exception e) {}

            if (accountName != null) {
                if (accountName.length() < 3 || accountName.length() > 30) {
                    System.out.println("Account name must be between 3 and 30 characters.");
                    accountName = null;
                } else if (accountName.charAt(0) == ' ' || accountName.charAt(accountName.length() - 1) == ' ') {
                    System.out.println("Account name must not begin or end with a space.");
                    accountName = null;
                } else if (accountName.matches("[a-zA-Z0-9]*") == false) {
                    System.out.println("Account name must be alphanumeric.");
                    accountName = null;
                }
            }
        }

        return accountName;
    }
}