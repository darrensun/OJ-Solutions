package com.darrensun.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Timus 1319 - Hotel
 * Created by Darren on 14-7-9.
 */
public class Q1319 {
    private int n;
    private int[][] shelves;

    public Q1319() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        shelves = new int[n][n];
        int counter = 1;
        // Right half
        for (int j = n-1; j >= 0; j--) {
            int k = j;
            for (int i = 0; k < n; i++, k++)
                shelves[i][k] = counter++;
        }
        // Left half
        for (int i = 1; i < n; i++) {
            int k = i;
            for (int j = 0; k < n; j++, k++)
                shelves[k][j] = counter++;
        }
    }

    public static void main(String[] args) {
        Q1319 q1319 = new Q1319();
        q1319.printShelves();
    }

    public void printShelves() {
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(shelves[i][j]);
                out.print(' ');
            }
            out.println();
        }
        out.flush();
    }
}
