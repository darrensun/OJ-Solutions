package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1131 - Copying
 * Created by Darren on 14-7-10.
 */
public class Q1131 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        // Suppose the number of cables is more than the computers with the program before each
        // minute during the process. After m minutes, 2^m computers have the program,
        // using 2^{m-1} cables
        int m = (int) Math.floor(Math.log(n) / Math.log(2));

        // In case the cables are not sufficient
        if ((1 << (m-1)) > k) {
            // k cables support full utilization of computers with the program until m minutes
            m = (int) Math.ceil(Math.log(k+1) / Math.log(2));
        }

        // r = n-2^m computers left;
        // In the former case, r < 2^m, i.e., more computers with the program than those without
        // the program. The only possible bottleneck is the number of cables.
        // In the latter case, the number of cables is already the bottlenect, i.e.,
        // at most k computers can get a copy of the program within a minute after the m-th
        // minute.
        System.out.println(m + (n-(1<<m)+k-1)/k);
    }
}
