package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1068 - Sum
 * Created by Darren on 14-7-9.
 */
public class Q1068 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println((1+n)*(Math.abs(n-1)+1)/2);
    }
}
