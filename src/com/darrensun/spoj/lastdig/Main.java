package com.darrensun.spoj.lastdig;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * SPOJ 7974 - What’s Next
 * Created by Darren on 14-7-15.
 * Periods for each single digit from 0 to 9: 1, 1, 4, 4, 2, 1, 1, 4, 4, 2
 * So the last digit of a^b is equal to the last digit of a^{b%4} when b%4 != 0 or a^4 when b%4==0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testcases = in.nextInt();
        for (int t = 0; t < testcases; t++) {
            int a = in.nextInt(), b = in.nextInt();
            if (b == 0) {
                out.println(1);
            } else {
                b = b % 4;
                if (b == 0)
                    b = 4;
                out.println(((int)Math.pow(a, b))%10);
            }
        }
        out.flush();
    }
}