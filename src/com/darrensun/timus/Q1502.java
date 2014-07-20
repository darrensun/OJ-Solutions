package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1502 - Domino Dots
 * Created by Darren on 14-7-11.
 * The number of dominoes in a special set: c = (n+1)(n+1)-(0+...+n)=(n+1)(n+2)/2.
 * Each domino has two ends, each having some number of dots. The number of ends for each number
 * of dots should be the same. So the number of ends for each number of dots is m = c*2/(n+1).
 * Therefore, the number of diamonds used is m*(0+...+n) = n(n+1)(n+2)/2.
 */
public class Q1502 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(n*(n+1)*(n+2)/2);
    }
}
