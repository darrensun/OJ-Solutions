package com.darrensun.spoj.nsteps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 1112 - Number Steps
 * Created by Darren on 14-7-15.
 * If (x,y) has a number on it, we must have y == x or y == x-2
 * Form groups of size 4: 0, 1, 2, 3; 4, 5, 6, 7; 8...
 * (x,y) has to be in group y/2, if there is a number on it.
 * The base value in group y/2 is base = y/2*4.
 * If y == x and y is even, the number on (x,y) is base.
 * If y == x and y is odd, the number on (x,y) is base+1.
 * If y == x-2 and y is even, the number on (x,y) is base+2.
 * If y == x-2 and y is odd, the number on (x,y) is base+3.
 * Otherwise, there is no number on (x,y).
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int base = y / 2 * 4;
            if (y == x) {
                if ((y & 1) == 0)
                    out.println(base);
                else
                    out.println(base+1);
            } else if (y == x - 2) {
                if ((y & 1) == 0)
                    out.println(base+2);
                else
                    out.println(base+3);
            } else {
                out.println("No Number");
            }
        }
        out.flush();
    }
}
