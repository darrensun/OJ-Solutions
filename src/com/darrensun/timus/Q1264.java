package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1264 - Workdays
 * Created by Darren on 14-7-8.
 */
public class Q1264 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(n*(m+1));
    }
}
