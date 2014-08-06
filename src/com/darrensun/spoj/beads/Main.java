package com.darrensun.spoj.beads;

import java.io.*;

/**
 * SPOJ 48 - Glass Beads
 * Created by Darren on 14-8-5.
 * The problem of the lexicographically minimal string rotation.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve(in.readLine().toCharArray());
        }
        out.flush();
    }

    // Duval's algorithm, with O(n) time
    void solve(char[] necklace) {
        int n = necklace.length, range = n<<1;
        int i = 0, j = 1, gap = 0;
        while (i+gap < range && j+gap < range) {
            char ci = (i+gap < n) ? necklace[i+gap] : necklace[i+gap-n];
            char cj = (j+gap < n) ? necklace[j+gap] : necklace[j+gap-n];
            if (ci == cj) {
                gap++;
            } else if (ci < cj) {
                j = (j+gap+1 > i) ? j+gap+1 : i+1;
                gap = 0;
            } else {
                i = (i+gap+1 > j) ? i+gap+1 : j+1;
                gap = 0;
            }
        }
        out.println((i < j) ? i+1 : j+1);
    }

//    // O(n^2) in the worst case
//    void solve(char[] necklace) {
//        int n = necklace.length;
//        int worst = 0;
//        for (int i = 1; i < n; i++) {
//            if (necklace[i] < necklace[worst] ||
//                    necklace[i] == necklace[worst] && worse(i, worst, necklace))
//                worst = i;
//        }
//        out.println(worst+1);
//    }
//
//    boolean worse(int i, int j, char[] necklace) {
//        int n = necklace.length;
//        for (int k = 0; k < n; k++) {
//            if (necklace[i] < necklace[j])
//                return true;
//            if (necklace[i] > necklace[j])
//                return false;
//            i = (i==n-1) ? 0 : i+1;
//            j = (j==n-1) ? 0 : j+1;
//        }
//        return false;
//    }
}
