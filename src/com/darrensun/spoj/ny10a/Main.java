package com.darrensun.spoj.ny10a;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 8612 - Penney Game
 * Created by Darren on 14-7-20.
 * 38 such sequences in total, each corresponding with a predefined sequence.
 * Encoding: TTT(000), TTH(001), ..., HHH(111)
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public final static int TOSSES = 40;

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws Exception {
        int n = Integer.parseInt(in.readLine());
        int[] count = new int[8];

        // Update count[] for each sequence
        int sequence = 0;
        for (int i = 0; i < 3; i++) {
            sequence <<= 1;
            if ((char) in.read() == 'H')
                sequence++;
        }
        count[sequence]++;
        for (int i = 3; i < TOSSES; i++) {
            sequence = (sequence<<1) & 7;
            if ((char) in.read() == 'H')
                sequence++;
            count[sequence]++;
        }
        in.read();  // ignore '\n'

        // Print the stat for the given data set
        out.print(n);
        out.print(' ');
        for (int i = 0; i < 8; i++) {
            out.print(count[i]);
            out.print(' ');
        }
        out.println();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
