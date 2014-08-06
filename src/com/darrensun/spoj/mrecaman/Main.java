package com.darrensun.spoj.mrecaman;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * SPOJ 3934 - Recaman’s Sequence
 * Created by Darren on 14-8-3.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    private static int[] a = new int[500001];
    private static Set<Integer> used = new HashSet<Integer>(500001);

    static {
        int last = 0;
        for (int i = 1; i <= 500000; i++) {
            if (last-i > 0 && !used.contains(last-i))
                last -= i;
            else
                last += i;
            a[i] = last;
            used.add(last);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int m;
        while ((m = Integer.parseInt(in.readLine())) != -1)
            out.println(a[m]);
        out.flush();
    }
}
