package com.darrensun.spoj.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 1 - Life, the Universe, and Everything
 * Created by Darren on 14-7-12.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        while (!(line = in.readLine()).startsWith("42"))
            out.println(line);
        out.flush();
    }
}
