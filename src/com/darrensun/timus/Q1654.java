package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Timus 1654 - Cipher Message
 * Created by Darren on 14-7-10.
 */
public class Q1654 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            String cipher = in.readLine();
            StringBuilder message = new StringBuilder();

            // Add to the message if current character is different from the last one in the
            // message, or delete the last character otherwise.
            for (int i = 0; i < cipher.length(); i++) {
                char c = cipher.charAt(i);
                if (message.length() == 0 || message.charAt(message.length()-1) != c)
                    message.append(c);
                else
                    message.deleteCharAt(message.length()-1);
            }

            System.out.println(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
