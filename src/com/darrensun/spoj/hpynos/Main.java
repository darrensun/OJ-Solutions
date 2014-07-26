package com.darrensun.spoj.hpynos;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * SPOJ 7733 - Happy Numbers I
 * Created by Darren on 14-7-21.
 * Brute force approach with care on space usage.
 * For at-most-10-digits numbers, the maximum result of breaking is 810 (all 9's). So an array of
 * size 810 suffices for the interger within the given range.
 */
public class Main {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        new Main().run();
    }

    void run() {
        int n = in.nextInt();
        boolean[] mark = new boolean[810];
        int count = 1;  // Number of times the breaking process is done
        while (true) {
            n = breaking(n);
            if (n == 1) {   // n is happy
                out.print(count);
                break;
            }
            if (mark[n]) {  // n has occurred before; this forms an infinite loop
                out.print(-1);
                break;
            }
            mark[n] = true; // Mark n's occurrance
            count++;
        }
        out.flush();
    }

    /**
     * Calculate the result of breaking a given integer.
     * @param n The given integer.
     * @return The result of breaking n.
     */
    int breaking(int n) {
        int squareSum = 0;
        while (n > 0) {
            int remainder = n % 10;
            squareSum += remainder * remainder;
            n /= 10;
        }
        return squareSum;
    }
}
