package com.darrensun.spoj.cprmt;

import java.io.*;

/**
 * SPOJ 1728 - Common Permutation
 * Created by Darren on 14-7-26.
 * Find the common characters in both strings, and construct one string using the common
 * characters in alphabetical order.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        String a, b;
        while ((a = in.readLine()) != null) {
            b = in.readLine();
            solve(a, b);
        }
        out.flush();
    }

    void solve(String a, String b) {
        int[] counts = new int[26];
        int m = a.length(), n = b.length();

        // Count the number of appearances for each character in string a
        for (int i = 0; i < m; i++) {
            char c = a.charAt(i);
            if (c >= 'a' && c <= 'z')
                counts[a.charAt(i)-'a']++;
        }

        // Count the number of common appearances for each character in both strings
        int[] commons = new int[26];
        for (int i = 0; i < n; i++) {
            char c = b.charAt(i);
            if (c >= 'a' && c <= 'z' && counts[c-'a'] > 0) {
                commons[c-'a']++;
                counts[c-'a']--;
            }
        }

        // Construct a string using the common characters in alphabetic order
        StringBuilder result = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            while (commons[c-'a'] > 0) {
                result.append(c);
                commons[c-'a']--;
            }
        }

        out.println(result.toString());
    }
}
