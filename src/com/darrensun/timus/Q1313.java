package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Timus 1313 - Some Words about Sport
 * Created by Darren on 14-7-9.
 */
public class Q1313 {
    private int n;
    private int[][] pixels;

    public Q1313() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        pixels = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++)
                pixels[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        try {
            Q1313 q1313 = new Q1313();
            q1313.OutputToNewMonitor();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Output the converted sequence of pixels to the new monitor.
     */
    public void OutputToNewMonitor() {
        PrintWriter out = new PrintWriter(System.out);
        // For the first half, each diagonal scan starts with the first column.
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = 0; k >= 0; j++, k--) {
                out.print(pixels[k][j]);
                out.print(' ');
            }
        }
        // For the second half, each diagonal scan starts with the last row.
        for (int j = 1; j < n; j++) {
            int k = j;
            for (int i = n-1; k < n; k++, i--) {
                out.print(pixels[i][k]);
                out.print(' ');
            }
        }
        out.flush();
    }
}
