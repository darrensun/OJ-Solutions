package com.darrensun.spoj.invcnt;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 6256 - Inversion Count
 * Created by Darren on 14-7-18.
 * Count the number of inversions by adapting from MergeSort.
 * The total number of inversions equal
 *  1. the number of inversions in the first half, plus
 *  2. the number of inversions in the second half, plus
 *  3. the number of inversion between the first half and the second half.
 * For the third part, it is done during the "merge" phase when comparing leftHalf[i] and
 * rightHalf[j]. If r[j] < l[i], r[j] and each number preceding l[i] (inclusive) form an
 * inversion. The number of inversions contributed by r[j] between these halves is leftLength-i.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            in.readLine();
            int n = Integer.parseInt(in.readLine());
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = Integer.parseInt(in.readLine());
            out.println(solve(array, n));
        }
        out.flush();
    }

    long solve(int[] array, int n) throws Exception {
        if (n == 1)
            return 0;

        // Separate the array into two halves
        int middle = (n-1) / 2;
        int leftLength = middle+1, rightLength = n-1-middle;
        int[] leftHalf = new int[leftLength];
        for (int i = 0; i < leftLength; i++)
            leftHalf[i] = array[i];
        int[] rightHalf = new int[rightLength];
        for (int i = 0; i < rightLength; i++)
            rightHalf[i] = array[middle+1+i];

        // Add the number of inversions in each half
        long inversions = solve(leftHalf, leftLength) + solve(rightHalf, rightLength);

        // Add the number of inversions between the halves
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftHalf[i] <= rightHalf[j]) {
                array[k++] = leftHalf[i++];
            } else {
                array[k++] = rightHalf[j++];
                inversions += leftLength - i;   // found more inversions
            }
        }
        while (i < leftLength)
            array[k++] = leftHalf[i++];
        while (j < rightLength)
            array[k++] = rightHalf[j++];

        return inversions;
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

}
