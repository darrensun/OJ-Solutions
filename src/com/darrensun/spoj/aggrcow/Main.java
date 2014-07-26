package com.darrensun.spoj.aggrcow;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ 297 - Aggressive cows
 * Created by Darren on 14-7-23.
 * Transform the problem into its "decision one", that is, tell whether the minimum distance
 * between cows can be a given value. Then apply binary search due the the property that if a
 * minimum distance of d cannot be achieved, neither can d+i (i>0) be achieved.
 * The time complexity of the resulting algorithm is O(n*logr) where r is the range of positions.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    void solve() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int stalls = Integer.parseInt(tokenizer.nextToken());
        int cows = Integer.parseInt(tokenizer.nextToken());
        int[] stallPositions = new int[stalls];
        for (int i = 0; i < stalls; i++)
            stallPositions[i] = Integer.parseInt(in.readLine());
        Arrays.sort(stallPositions);
        out.println(binarySearch(cows, stallPositions));
    }

    /**
     * Conduct a binary search to find the largest distance d such that the minimum distance of d
     * is achieveable, while the minimum distance of d is not.
     * @param cows The number of cows.
     * @param positions the positions of stalls in non-descending order.
     * @return the largest minimum distance.
     */
    int binarySearch(int cows, int[] positions) {
        int left = 0, right = positions[positions.length-1]-positions[0];
        while (left <= right) {
            int middle = (left + right) / 2;
            if (validMinDistance(middle, cows, positions))
                left = middle + 1;
            else
                right = middle - 1;
        }
        return right;
    }

    /**
     * Check whether a given distance can be the minimum distance between cows.
     * @param distance the given distance.
     * @param cows the numberof cows.
     * @param positions the positions of stalls in non-descending order.
     * @return true if the given distance can be the minimum distance, false otherwise.
     */
    boolean validMinDistance(int distance, int cows, int[] positions) {
        int cowPlaced = 1;
        int lastPosition = positions[0];
        for (int i = 1; i < positions.length; i++) {
            if (positions[i]-lastPosition < distance)
                continue;
            if (++cowPlaced == cows)
                return true;
            lastPosition = positions[i];
        }
        return false;
    }
}
