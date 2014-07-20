package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Timus 2011 - Long Statement
 * Created by Darren on 14-7-11.
 * No need to calculate C(n,count[0]) * C(n-count[0], count[1]). It may lead to overflow.
 */
public class Q2011 {
    public final static int THRESHOLD = 6;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());

            // Count the number of the characters
            int[] count = new int[3];
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
                count[Integer.parseInt(tokenizer.nextToken())-1]++;

            // The number of different words would be C(n,count[0]) * C(n-count[0], count[1])
            Arrays.sort(count);

            // Check whether the number of different words is at least 6 without computing the
            // number of combinations. It is fine when the threshold is small.
            if (n >= 6 && (count[0] > 0 || count[1] > 0) ||
                    (n == 5 || n == 4) && (count[0] >= 1 || count[1] > 1) ||
                    n == 3 && count[0] == 1 && count[1] == 1)
                System.out.println("Yes");
            else
                System.out.println("No");
//            long numOfDifferentWords = numOfCombinations(n, count[0]) *
//                    numOfCombinations(n-count[0], count[1]);
//            if (numOfDifferentWords >= THRESHOLD)
//                System.out.println("Yes");
//            else
//                System.out.println("No");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static long numOfCombinations(int n, int k) {
//        assert n >= 0 && k >= 0;
//        double num = 1;
//        for (int i = 0; i < k; i++)
//            num *= ((double) (n-i)) / (i+1);
//        return (long) num;
//    }
}
