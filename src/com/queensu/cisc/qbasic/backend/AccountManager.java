package com.queensu.cisc.qbasic.backend;

import java.io.*;
import java.util.*;

/*
    Account Manager is responsible for loading in the Master Accounts File. Then it is responsible for checking whether or not
    a given account number is in the Valid Accounts List.
 */
public class AccountManager {
    public static class Account {
        public int number;
        public int balance;
        public String name;

        public Account(int number, int balance, String name) {
            this.number = number;
            this.balance = balance;
            this.name = name;
        }
    }

    private static boolean initialized = false;
    private static Map<Integer, Account> accounts = new TreeMap<Integer, Account>();
    // Initialize loads in the Valid Account List using File Reader.
    public static void Initialize(String accountFile) {
        if (initialized == true) {
            return;
        }

        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(accountFile));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("Can't load accountFile with FileReader, trying as resource.");
            try {
                inputStream = new BufferedReader(new InputStreamReader(AccountManager.class.getResourceAsStream("/" + accountFile)));
            } catch (Exception ee) {
                System.out.println("Failed to load accounts file.");
                // Continue with empty account list
                return;
            }
        }

        try {
            String line;
            while ((line = inputStream.readLine()) != null) {
                try {
                    String[] items = line.split(" ", 2);
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
    //Exists checks if a given accountNumber is contained within the Valid Accounts List.
    public static boolean Exists(int accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    public static void Create(int accountNumber, String name) {
        if (accounts.containsKey(accountNumber) == false) {
            accounts.put(accountNumber, new Account(accountNumber, 0, name));
        }
    }

    public static void Delete(int accountNumber) {
        accounts.remove(accountNumber);
    }

    public static void SetBalance(int accountNumber, int balance) {
        Account a = accounts.get(accountNumber);
        if (a != null) {
            a.balance = balance;
        }
    }
}
