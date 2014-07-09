package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1349 - Farm
 * Created by Darren on 14-7-9.
 * Fermat's Last Theorem: no three positive integers a, b, and c can satisfy the equation a^n +
 * b^n = c^n for any integer value of n greater than two.
 */
public class Q1349 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 1)
            System.out.println(String.format("%d %d %d", 1, 2, 3));
        else if (n == 2)
            System.out.println(String.format("%d %d %d", 3, 4, 5));
        else
            System.out.println(-1);
    }
}
