package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1820 - Ural Steaks
 * Created by Darren on 14-7-8.
 * Optimal strategy: cook one side of all steaks and then the other side
 */
public class Q1820 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (n <= k)
            System.out.println(2);
        else
            System.out.println(n/k+1+(n%k+n-1)/k);
    }
}
