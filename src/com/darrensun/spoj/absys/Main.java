package com.darrensun.spoj.absys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * SPOJ 2157 - Anti-Blot System
 * Created by Darren on 14-7-16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");   // Used to match for integers
        int testcases = Integer.parseInt(in.readLine());
        int a = 0, b = 0, c = 0;
        for (int t = 0; t < testcases; t++) {
            in.readLine();  // Ignore the empty line between testcases
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int errorCode = 0;  // Indicate which number gets corrupted

            String token = tokenizer.nextToken();
            if (pattern.matcher(token).matches())
                a = Integer.parseInt(token);
            else
                errorCode = 1;

            tokenizer.nextToken();
            token = tokenizer.nextToken();
            if (pattern.matcher(token).matches())
                b = Integer.parseInt(token);
            else
                errorCode = 2;

            tokenizer.nextToken();
            token = tokenizer.nextToken();
            if (pattern.matcher(token).matches())
                c = Integer.parseInt(token);
            else
                errorCode = 3;

            // Recover the expression based on the error code
            switch (errorCode) {
                case 1 : out.printf("%d + %d = %d\n", c-b, b, c); break;
                case 2 : out.printf("%d + %d = %d\n", a, c-a, c); break;
                case 3 : out.printf("%d + %d = %d\n", a, b, a+b); break;
            }
        }
        out.flush();
    }
}
