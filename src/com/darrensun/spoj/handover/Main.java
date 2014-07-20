package com.darrensun.spoj.handover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 902 - Hangover
 * Created by Darren on 14-7-16.
 * Due to the limited numbers of different input values, we can precalculate
 * 1/2+...+1/(i+1) and save the results in an array. Then we perform a binary search on the
 * array to find the index at which the value is the smallest that is larger than a given target.
 */
public class Main {
    //
    public final static int RANGE = 280;    // 1/2+...+1/280 > 5.20
    private static double[] results = new double[RANGE+1];
    static {
        for (int i = 1; i <= RANGE; i++)
            results[i] = results[i-1] + 1.0/(i+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        double sum;
        while ((sum = Double.parseDouble(in.readLine())) != 0.0) {
            out.print(binarySearch(sum));
            out.println(" card(s)");
        }
        out.flush();
    }

    /**
     * Find by binary search the index j at which the value is the smallest that is larger than a
     * given target.
     * @param target The given target value.
     * @return results[j] is the smallest value that is larger than the target value.
     */
    private static int binarySearch(double target) {
        int left = 1, right = RANGE;
        while (left < right) {
            int middle = (left+right) / 2;
            if (results[middle] == target)
                return middle;
            else if (results[middle] < target)
                left = middle + 1;
            else
                right = middle; // Ensure results[right] >= target
        }
        return right;
    }
}
