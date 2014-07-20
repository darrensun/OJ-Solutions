package com.darrensun.spoj.lastdig2;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * SPOJ 5699 - The last digit re-visited
 * Created by Darren on 14-7-20.
 * See a similar problem at SPOJ LASTDIG
 */
public class Main {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            String first = in.next();
            int a = first.charAt(first.length()-1) - '0';
            long b = in.nextLong();
            if (b == 0)
                out.println(1);
            else {
                b %= 4;
                if (b == 0)
                    b = 4;
                out.println(((int)Math.pow(a, b))%10);
            }
        }
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
