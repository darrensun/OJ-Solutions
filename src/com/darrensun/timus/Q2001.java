package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 2001 - Mathematicians and Berries
 * Created by Darren on 14-7-9.
 * x1+y1 = a1; x2+y2 = b1; y2 = b2; y1 = a3
 */
public class Q2001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a1 = in.nextInt(), b1 = in.nextInt();
        in.nextInt();
        int b2 = in.nextInt(), a3 = in.nextInt();
        in.nextInt();
        System.out.println(String.format("%d %d", a1-a3, b1-b2));
    }
}
