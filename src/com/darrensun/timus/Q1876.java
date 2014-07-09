package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1876 - Centipede's Morning
 * Created by Darren on 14-7-9.
 * Basic: 80 to put on shoes for all feets
 * Worst-case extra time when left feets are done before right feets: 39+2*(a-40),
 * where 39 are putting on right shoes passed from the left foot, and 2*(a-40) are throwing all
 * extra left shoes by the right foot.
 * Worst-case extra time when left feets are done after right feets: 40+2*(b-40),
 * where 40 are putting on right shoes passed from the left foot, and 2*(b-40_ are throwing all
 * extra right shoes by the left foot.
 */
public class Q1876 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (b >= a)
            System.out.println(40+2*b);
        else
            System.out.println(39+2*a);
    }
}
