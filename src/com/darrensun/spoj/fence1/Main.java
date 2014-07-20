package com.darrensun.spoj.fence1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 4408 - Build a Fence
 * Created by Darren on 14-7-17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int l;
        while ((l = Integer.parseInt(in.readLine())) != 0) {
            out.printf("%.2f\n", l*l/(2*Math.PI));
        }
        out.flush();
    }
}
