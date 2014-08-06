package com.darrensun.spoj.maya;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * SPOJ 94 - Numeral System of the Maya
 * Created by Darren on 14-7-29.
 * Solved by adapting Horner's rule.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    // A map between Maya symbols and decimal numbers from 0 to 19
    private static Map<String, Integer> symbolToDecimal = new HashMap<String, Integer>();
    static {
        symbolToDecimal.put("S", 0);
        symbolToDecimal.put(".", 1);
        symbolToDecimal.put("..", 2);
        symbolToDecimal.put("...", 3);
        symbolToDecimal.put("....", 4);
        symbolToDecimal.put("-", 5);
        symbolToDecimal.put(". -", 6);
        symbolToDecimal.put(".. -", 7);
        symbolToDecimal.put("... -", 8);
        symbolToDecimal.put(".... -", 9);
        symbolToDecimal.put("- -", 10);
        symbolToDecimal.put(". - -", 11);
        symbolToDecimal.put(".. - -", 12);
        symbolToDecimal.put("... - -", 13);
        symbolToDecimal.put(".... - -", 14);
        symbolToDecimal.put("- - -", 15);
        symbolToDecimal.put(". - - -", 16);
        symbolToDecimal.put(".. - - -", 17);
        symbolToDecimal.put("... - - -", 18);
        symbolToDecimal.put(".... - - -", 19);
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int n;
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            solve(n);
            in.readLine();  // Ignore the empty line
        }
        out.flush();
    }

    void solve(int n) throws IOException {
        if (n == 1) {
            out.println(symbolToDecimal.get(in.readLine()));
            return;
        }

        // Horner's rule: e.g., abcd = (((a*20)+b)*18+c)*20+d
        int result = 0;
        for (int i = 0; i < n-2; i++)
            result = result * 20 + symbolToDecimal.get(in.readLine());
        result = result * 18 + symbolToDecimal.get(in.readLine());
        result = result * 20 + symbolToDecimal.get(in.readLine());

        out.println(result);
    }
}
