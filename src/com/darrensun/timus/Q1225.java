package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1225 - Flags
 * Created by Darren on 14-7-9.
 * W(n): number of ways to decorate the window with n stripes
 * W(n) = W(n-1) + W(n-2) for n >= 3, W(1) = 2, W(2) = 2
 * W(n) = F(n) * 2, where F(n) is the n-th Fibonacci number.
 * F(n) = phi^n / sqrt(5) rounded to the nearest integer.
 */
public class Q1225 {
    public static final double PHI = (1 + Math.sqrt(5)) / 2.0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long fibonacciOfOrderN = Math.round(Math.pow(PHI, n) / Math.sqrt(5));
        System.out.println(fibonacciOfOrderN * 2);
    }

//    // It works fine, but not as fast as the one using the correspondence with Fibonacci numbers.
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        if (n == 1 || n == 2) {
//            System.out.println(2);
//            return;
//        }
//        long m1 = 2, m2 = 2;    // may grow beyond the max of int type, say when n=45.
//        for (int i = 3; i <= n; i++) {
//            long temp = m1 + m2;
//            m1 = m2;
//            m2 = temp;
//        }
//        System.out.println(m2);
//    }
}
