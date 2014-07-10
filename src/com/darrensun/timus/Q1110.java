package com.darrensun.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Timus 1110 - Power
 * Created by Darren on 14-7-9.
 * Use the fact that (a*b) mod m = (a mod m) * (b mod m) to avoid overflow
 * a^n can be computed in O(log n) time by using the binary representation of n.
 */
public class Q1110 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int m = in.nextInt();
        int y = in.nextInt();
        boolean foundOne = false;   // true if at least one solution is found

        // Simple cases
        if (y == 0) {   // x = 0 is a solution when y = 0
            foundOne = true;
            out.print(0);
            out.print(' ');
        }
        if (y == 1) {   // x = 1 is a solution when y = 1
            foundOne = true;
            out.print(1);
            out.print(' ');
        }

        // General cases
        for (int i = 2; i < m; i++) {
            int k = 1, power = i, nCopy = n;
            // Calculate row^n mod m (saved as k)
            while (nCopy != 0) {
                if ((nCopy & 1) == 1)
                    k = (k * power) % m;
                power = (power * power) % m;
                nCopy >>= 1;
            }
            if (k == y) {
                foundOne = true;
                out.print(i);
                out.print(' ');
            }
        }

        if (!foundOne)
            out.print(-1);
        out.flush();
    }
}
