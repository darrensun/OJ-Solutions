package com.darrensun.spoj.amr10g;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ 8061 - Christmas Play
 * Created by Darren on 14-7-22.
 * Presorting.
 * After sorting the kids by their heights, for each kid i (0<=i<=n-k),
 * the minimum height difference is heights[i+k-1]-heights[i], if it was the one with minimum
 * height among the k kids. And each possble group of k kids must have one such kid whose
 * index is within [0,n-k].
 * The overall time complexity is O(n*logn), decided by the sorting algorithm used.
 * DP seems to be another way to solve it, with O(nk) time complexity.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        // Read heights of kids
        int[] heights = new int[n];
        tokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++)
            heights[i] = Integer.parseInt(tokenizer.nextToken());

        // Sort in non-descending order
        Arrays.sort(heights);

        // Find minimum height difference
        int minHeightDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n-k; i++)
            minHeightDiff = (heights[i+k-1]-heights[i] < minHeightDiff) ?
                    heights[i+k-1]-heights[i] : minHeightDiff;

        out.println(minHeightDiff);
    }
}
