package com.darrensun.spoj.ae00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 4300 - Rectangles
 * Created by Darren on 14-7-15.
 * This problem is essentially asking for the number of unordered pairs (i,j) such that i*j <= n.
 * For each i, the number of possible j's is n/i, j = 1, 2, ..., n/i.
 * To avoid duplicate pairs, we can assume i >= j. Then the number of possible j's is n/i-i+1,
 * j = i, i+1, ..., n/i.
 * Another way to approach this problem is to view it as R(n) = R(n-1)+F(n),
 * where F(n) is half the number of n's factors, rounding up when n has odd number of factors.
 * For example, F(9)=2. But this way requires factor decomposition.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        int numOfRectangles = 0;
        for (int i = 1; i <= n/i; i++)
            numOfRectangles += n/i - i + 1;
        out.println(numOfRectangles);
        out.flush();
    }
}
