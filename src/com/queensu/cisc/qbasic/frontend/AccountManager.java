package com.queensu.cisc.qbasic.frontend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountManager {
    private List<Integer> accounts = new ArrayList<Integer>();

    public AccountManager(String accountFile) {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(accountFile));

            String line;
            while ((line = inputStream.readLine()) != null) {
                try {
                    accounts.add(Integer.valueOf(line));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(int accountNumber) {
        return accounts.contains(accountNumber);
    }
}
