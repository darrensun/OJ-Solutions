package com.darrensun.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Timus 1209 - 1, 10, 100, 1000...
 * Created by Darren on 14-7-9.
 */
public class Q1209 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            double k = in.nextDouble(); // 8k may overflow if k is of type int
            double x = (Math.sqrt(8*k-7)-1) / 2.0;
            out.print((x==(int)x) ? 1 : 0);
            out.print(' ');
        }
        out.flush();
    }

//    // Time limit exceeded
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            int k = in.nextInt();
//            for (int column = 1; k - column > 0; column++)
//                k -= column;
//            out.print((k==1) ? 1 : 0);
//            out.print(' ');
//        }
//        out.flush();
//    }
}
