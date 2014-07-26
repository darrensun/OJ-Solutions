package com.darrensun.spoj.egypizza;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 7169 - Pizza
 * Created by Darren on 14-7-21.
 * Satisfy those requiring 3/4 slices first, and give the remaining 1/4 slices to those requiring
 * 1/4 slices. Then apply the same logic to those requiring 1/2 slices. After that if there are
 * friends requiring 1/4 slices left, each four of them share a pizza, and the remaining friends
 * who cannot form a full group share a pizza. Do not leave out a pizza for Abotrika himself.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int friends = Integer.parseInt(in.readLine());
        int[] amounts = new int[3];
        for (int i = 0; i < friends; i++)
            amounts[sliceIndex(in.readLine())]++;

        int total = amounts[0] + 1;
        if (amounts[0] <= amounts[2])
            amounts[2] -= amounts[0];
        else
            amounts[2] = 0;

        total += (amounts[1]+1) / 2;
        if ((amounts[1]&1) == 1)
            amounts[2] = (amounts[2]-2 >= 0) ? amounts[2]-2 : 0;

        total += (amounts[2]+3) / 4;

        out.println(total);
        out.flush();
    }

    int sliceIndex(String slice) {
        if (slice.charAt(2) == '2')  // 1/2
            return 1;
        if (slice.charAt(0) == '1')     // 1/4
            return 2;
        return 0;   // 3/4
    }
}
