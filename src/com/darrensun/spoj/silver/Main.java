package com.darrensun.spoj.silver;

import java.io.*;

/**
 * SPOJ 8785 - Cut the Silver Bar
 * Created by Darren on 14-7-29.
 * Observe the underlying pattern.
 * 1 2 3 4 5 6 7 8 9 10 ...
 * 0 1 1 2 2 2 2 3 3 3  ...
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int n;
        while ((n = Integer.parseInt(in.readLine())) != 0)
            out.println((int)(Math.log(n)/Math.log(2)));    // Floor of log_2(n)
        out.flush();
    }
}
