package com.darrensun.spoj.easyprob;

import java.io.PrintWriter;

/**
 * SPOJ 1688 - A Very Easy Problem!
 * Created by Darren on 14-7-18.
 */
public class Main {
    PrintWriter out = new PrintWriter(System.out);

    void run() {
        out.printf("137=%s\n", solve(137));
        out.printf("1315=%s\n", solve(1315));
        out.printf("73=%s\n", solve(73));
        out.printf("136=%s\n", solve(136));
        out.printf("255=%s\n", solve(255));
        out.printf("1384=%s\n", solve(1384));
        out.printf("16385=%s\n", solve(16385));
        out.flush();
    }

    String solve(int n) {
        if (n == 0)
            return "0";
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            int index = (int)(Math.log(n)/Math.log(2));
            if (index == 1) // 2 instead of 2(1)
                result.append("2+");
            else
                result.append(String.format("2(%s)+", solve(index)));
            n -= (1 << index);
        }
        result.deleteCharAt(result.length()-1); // Remove the extra trailing '+'
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
