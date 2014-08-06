package com.darrensun.spoj.uj;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * SPOJ 1002 - Uncle Jack
 * Created by Darren on 14-7-30.
 * Each CD can go to each nephew. The number of ways to distribute CDs is clearly n^d.
 */
public class Main {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int n = in.nextInt(), d = in.nextInt();
        while (n != 0 || d != 0) {
            out.println((new BigInteger(String.valueOf(n))).pow(d));
            n = in.nextInt();
            d = in.nextInt();
        }
        out.flush();
    }
}
