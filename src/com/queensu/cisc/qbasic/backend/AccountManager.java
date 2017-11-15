package com.queensu.cisc.qbasic.backend;

import java.io.*;
import java.util.*;

/*
    Account Manager is responsible for loading in the Master Accounts File.
    It is used by the transaction classes to make transactions on the accounts.

    It contains an Account class that stores the account number, balance, and account name.
    The Account class is responsible for validating balance updates.

    The Account Manager also provides methods to generate master accounts files and valid accounts files.
 */
public class AccountManager {
    // Class to represent individual accounts
    public static class Account {
        private int number;
        private int balance;
        private String name;

        public Account(int number, int balance, String name) {
            this.number = number;
            this.balance = balance;
            this.name = name;
        }

        // Verifies that the new balance is valid (>= 0)
        public boolean setBalance(int balance) {
            if (balance < 0) {
                System.out.println("Failed to update balance, cannot be negative.");
            } else {
                this.balance = balance;
                return true;
            }

            return false;
        }

        // Formatting corresponds to the master accounts file formatting
        public String toString() {
            return String.format("%07d %d %s", number, balance, name);
        }

        public int getNumber() {
            return number;
        }

        public int getBalance() {
            return balance;
        }

        public String getName() {
            return name;
        }
    }

    private static boolean initialized = false;
    // accounts maps account numbers to account instances
    private static Map<Integer, Account> accounts = new TreeMap<Integer, Account>();

    // Initialize loads in the Master Account List using File Reader.
    public static void Initialize(String accountFile) {
        if (initialized == true) {
            return;
        }

        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(accountFile));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Can't load masterAccountFile with FileReader, trying as resource.");
            try {
                inputStream = new BufferedReader(new InputStreamReader(AccountManager.class.getResourceAsStream("/" + accountFile)));
            } catch (Exception ee) {
                System.out.println("Failed to load master accounts file.");
                // Continue with empty account list
                return;
            }
        }

        try {
            String line;
            while ((line = inputStream.readLine()) != null) {
                try {
                    String[] items = line.split(" ", 3);
                    Integer accountNum = Integer.valueOf(items[0]);
                    Integer accountBal = Integer.valueOf(items[1]);
                    String accountName = items[2];

                    accounts.put(accountNum, new Account(accountNum, accountBal, accountName));
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
    }

    //Exists checks if a given accountNumber is contained within the accounts list.
    public static boolean Exists(int accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public static Account GetAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    // Creates a new account if the account number does not already exist.
    public static void Create(int accountNumber, String name) {
        if (accounts.containsKey(accountNumber) == false) {
            accounts.put(accountNumber, new Account(accountNumber, 0, name));
        } else {
            System.out.println("Failed to create account: account number " + accountNumber + " already exists.");
        }
    }

    // Deletes an account if the account number exists and the name provided matches the account name.
    public static void Delete(int accountNumber, String name) {
        Account acc = AccountManager.GetAccount(accountNumber);
        if (acc == null) {
            System.out.println("Failed to delete account: account number " + accountNumber + " does not exist.");
        } else if (acc.getName().equals(name) == false) {
            System.out.println("Failed to delete account: account name does not match.");
        } else {
            accounts.remove(accountNumber);
        }
    }

    // Generates a new master accounts file containing the accounts stored in the accounts list
    public static void GenerateNewMasterAccountsFile(String masterAccountFilename) {
        PrintWriter outputStream;
        try {
            outputStream = new PrintWriter(new FileWriter(masterAccountFilename));

            Iterator<Account> itr = accounts.values().iterator();
            while (itr.hasNext()) {
                outputStream.println(itr.next().toString());
            }

            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Generates a new valid accounts file containing the account numbers in the accounts list
    public static void GenerateNewValidAccountsFile(String validAccountFilename) {
        PrintWriter outputStream;
        try {
            outputStream = new PrintWriter(new FileWriter(validAccountFilename));

            Iterator<Account> itr = accounts.values().iterator();
            while (itr.hasNext()) {
                outputStream.println(String.format("%07d", itr.next().getNumber()));
            }

            outputStream.println("0000000");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
