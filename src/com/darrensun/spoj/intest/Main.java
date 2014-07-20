package com.darrensun.spoj.intest;

import java.io.*;

/**
 * SPOJ 450 - Enormous Input Test
 * Created by Darren on 14-7-17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        String[] firstLine = in.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        int count = 0;
        while (n-- > 0) {
            int t = Integer.parseInt(in.readLine());
            if (t % k == 0)
                count++;
        }
        out.println(count);
        out.flush();
    }
}
