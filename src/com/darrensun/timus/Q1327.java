package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1327 - Fuses
 * Created by Darren on 14-7-9.
 */
public class Q1327 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int numOfDays = b - a + 1;
        if ((numOfDays & 1) == 0 || (a & 1) == 0)
            System.out.println(numOfDays/2);
        else
            System.out.println(numOfDays/2+1);
    }
}
