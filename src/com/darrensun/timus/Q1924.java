package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1924 - Four Imps
 * Created by Darren on 14-7-9.
 * Pattern: odd, odd, even, even; ...
 */
public class Q1924 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if ((n & 3) == 1 || (n & 3) == 2)
            System.out.println("grimy");
        else
            System.out.println("black");
    }
}
