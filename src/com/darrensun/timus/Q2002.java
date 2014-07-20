package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Timus 2002 - Test Task
 * Created by Darren on 14-7-11.
 */
public class Q2002 {

    /**
     * A single account
     */
    class Account {
        private String username;
        private String password;
        private boolean loginStatus;    // true if logged in, false if logged out

        public Account(String username, String password) {
            this.username = username;
            this.password = password;
            this.loginStatus = false;
        }

        public String getPassword() {
            return password;
        }

        public boolean getLoginStatus() {
            return loginStatus;
        }

        public void login() {
            loginStatus = true;
        }

        public void logout() {
            loginStatus = false;
        }
    }

    public final static String USER_EXISTS = "fail: user already exists";
    public final static String USER_ADDED = "success: new user added";
    public final static String NO_SUCH_USER = "fail: no such user";
    public final static String INCORRECT_PASSWORD = "fail: incorrect password";
    public final static String ALREADY_LOGGED_IN = "fail: already logged in";
    public final static String USER_LOGGED_IN = "success: user logged in";
    public final static String ALREADY_LOGGED_OUT = "fail: already logged out";
    public final static String USER_LOGGED_OUT = "success: user logged out";

    Map<String, Account> accounts = new HashMap<String, Account>(); // All acccounts
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Q2002 q2002 = new Q2002();
        try {
            q2002.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read commands from standard input and execute them one by one.
     * @throws IOException If the input format is incorrect.
     */
    public void run() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = in.readLine().split(" ");
            if (command[0].equals("register"))
                register(command[1], command[2]);
            else if (command[0].equals("login"))
                login(command[1], command[2]);
            else if (command[0].equals("logout"))
                logout(command[1]);
        }
        out.flush();
    }

    /**
     * Register a new account with given username and password.
     * @param username The given username.
     * @param password The given password.
     */
    public void register(String username, String password) {
        if (accounts.containsKey(username))
            out.println(USER_EXISTS);
        else {
            accounts.put(username, new Account(username, password));
            out.println(USER_ADDED);
        }
    }

    /**
     * Login an account with given username and password.
     * @param username The given username.
     * @param password The given password.
     */
    public void login(String username, String password) {
        if (!accounts.containsKey(username)) {
            out.println(NO_SUCH_USER);
        } else {
            Account account = accounts.get(username);
            if (!account.getPassword().equals(password)) {
                out.println(INCORRECT_PASSWORD);
            } else if (account.getLoginStatus()) {
                out.println(ALREADY_LOGGED_IN);
            } else {
                account.login();
                out.println(USER_LOGGED_IN);
            }
        }
    }

    /**
     * Logout an account with given username.
     * @param username The given username.
     */
    public void logout(String username) {
        if (!accounts.containsKey(username)) {
            out.println(NO_SUCH_USER);
        } else {
            Account account = accounts.get(username);
            if (!account.getLoginStatus()) {
                out.println(ALREADY_LOGGED_OUT);
            } else {
                account.logout();
                out.println(USER_LOGGED_OUT);
            }
        }
    }

}
