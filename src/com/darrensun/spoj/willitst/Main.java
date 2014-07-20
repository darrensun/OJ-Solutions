package com.darrensun.spoj.willitst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 9948 - Will it ever stop
 * Created by Darren on 14-7-17.
 * When n is a power of 2, it will stop. But as long as the "else" block has ever been
 * executed, i.e., n has a factor other than 2, 3 will be a factor of n all the time. This makes
 * the loop unstopable. So the indicator is whether n is a power of 2 in the very beginning. This
 * can be determined by checking whether n & (n-1) == 0.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        long n = Long.parseLong(in.readLine());
        if ((n & (n-1)) == 0)
            out.println("TAK");
        else
            out.println("NIE");
        out.flush();
    }
}
