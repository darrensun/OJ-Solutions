package com.darrensun.spoj.acpc10a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 7974 - What’s Next
 * Created by Darren on 14-7-15.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int a1 = Integer.parseInt(tokenizer.nextToken());
            int a2 = Integer.parseInt(tokenizer.nextToken());
            int a3 = Integer.parseInt(tokenizer.nextToken());
            if (a1 == 0 && a2 == 0 && a3 == 0)
                break;

            if (a1+a3 == (a2<<1) && a1 != a2) { // Note that a, a, a is thought to be a GP
                out.print("AP");
                out.print(' ');
                out.println(a3+a2-a1);
            } else {
                out.print("GP");
                out.print(' ');
                out.println(a3*a2/a1);
            }
        }
        out.flush();
    }
}
