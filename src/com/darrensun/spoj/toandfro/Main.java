package com.darrensun.spoj.toandfro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 400 - To and Fro
 * Created by Darren on 14-7-15.
 * No need to allocate a matrix before translating the cipher. For each character in the cipher,
 * the next character of its corresponding one in the message is known with constant offset every
 * other row. For the given example, the charaters of "there" appear at positions 0, 9, 10, 19, 20.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int column;
        while ((column = Integer.parseInt(in.readLine())) != 0) {
            String cipher = in.readLine();
            int length = cipher.length();
            StringBuilder message = new StringBuilder(length);

            // Retrieve a column of the message in each loop
            for (int i = 0; i < column; i++) {
                int j = i;
                // Offsets between adjacent characters differ for every other line
                boolean onEvenLine = true;
                while (j < length) {
                    message.append(cipher.charAt(j));
                    if (onEvenLine)
                        j += ((column-i)<<1) - 1;   // On even line: offset = 2(column-j)-1
                    else
                        j += (i<<1) + 1;    // On odd line: offset = 2*j+1
                    onEvenLine = !onEvenLine;   // Switch to next line
                }
            }

            out.println(message);
        }
        out.flush();
    }
}
