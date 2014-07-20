package com.darrensun.spoj.hs08test;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * SPOJ 2980 - ATM
 * Created by Darren on 14-7-17.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int withdraw = in.nextInt();
        double balance = in.nextDouble();
        if (withdraw % 5 == 0 && balance-withdraw >= 0.5)
            out.printf("%.2f\n", balance-withdraw-0.5);
        else
            out.printf("%.2f\n", balance);
        out.flush();
    }
}
