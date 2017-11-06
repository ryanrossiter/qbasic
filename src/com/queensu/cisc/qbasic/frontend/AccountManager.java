package com.queensu.cisc.qbasic.frontend;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*
    Account Manager is responsible for loading in the Valid Account List. Then it is responsible for checking whether or not
    a given account number is in the Valid Accounts List.
 */
public class AccountManager {
    private static boolean initialized = false;
    private static List<Integer> accounts = new ArrayList<Integer>();
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
                    Integer accountNum = Integer.valueOf(line);
                    if (accountNum.equals(0) == false) { // ignore special invalid account number
                        accounts.add(accountNum);
                    } else {
                        break; // break on 0000000
                    }
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
        return accounts.contains(accountNumber);
    }

    public static void Delete(int accountNumber) {
        accounts.remove(Integer.valueOf(accountNumber));
    }
}
