package com.darrensun.spoj.tsort;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * SPOJ 500 - Turbo Sort
 * Created by Darren on 14-7-17.
 * Lazy approach by using Arrays.sort().
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = Integer.parseInt(in.readLine());
        int[] array = new int[t];
        for (int i = 0; i < t; i++)
            array[i] = Integer.parseInt(in.readLine());

        Arrays.sort(array);     // Sort the array in non-descending order

        for (int i = 0; i < t; i++)
            out.println(array[i]);
        out.flush();
    }
}
