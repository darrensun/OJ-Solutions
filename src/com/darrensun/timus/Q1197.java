package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Timus 1197 - Lonesome Knight
 * Created by Darren on 14-7-8.
 * Prestore the number of moves for each possible position.
 */
public class Q1197 {
    private final int SIZE = 8;
    private int n;
    private int[] ranks;    // Value range 0 ~ 7
    private int[] files;    // Value range 0 ~ 7
    private int[][] map = {
            {2, 3, 4, 4, 4, 4, 3, 2},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {4, 6, 8, 8, 8, 8, 6, 4},
            {3, 4, 6, 6, 6, 6, 4, 3},
            {2, 3, 4, 4, 4, 4, 3, 2},
    };

    public Q1197() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        ranks = new int[n];
        files = new int[n];
        for (int i = 0; i < n; i++) {
            String str = in.readLine();
            ranks[i] = str.charAt(0) - 'a';
            files[i] = str.charAt(1) - '1';
        }
    }

    public static void main(String[] args) {
        try {
            Q1197 q1197 = new Q1197();
            q1197.printNumOfMoves();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print the number of moves for the knights at each position.
     */
    public void printNumOfMoves() {
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            out.println(map[ranks[i]][files[i]]);
        }
        out.flush();
    }
}
