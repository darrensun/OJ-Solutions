package com.darrensun.spoj.disubstr;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * SPOJ 694 - Distinct Substrings
 * Created by Darren on 14-7-29.
 * Solved with suffix array.
 * Observation: A substring of S is a prefix of some suffix of S.
 * After sorting the suffix array sa, the number of distinct substrings contributed by the
 * suffix s[sa[i],n-1] is n-sa[i]-lcp[i], where lcp[i] is the length of the longest common
 * prefix between s[sa[i-1],n-1] and s[sa[i],n-1].
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    void solve() throws IOException {
        // Declared as final due the their usage in building a comparator
        final char[] str = in.readLine().toCharArray();
        final int n = str.length;

        // Construct suffix array
        // suffixArray[i] represents str.substring(suffixArray[i], n)
        Integer[] suffixArray = new Integer[n]; // Integer instead of int for using Arrays.sort()
        for (int i = 0; i < n; i++)
            suffixArray[i] = i;

        // Sort the suffix array by the suffixes
        Arrays.sort(suffixArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int i = o1, j = o2;
                for(; i < n && j < n; i++, j++) {
                    if (str[i] != str[j])
                        return str[i] - str[j];
                }
                return j-i;
            }
        });

        // Find the length of the longest common prefix for consecutive suffixes
        int[] lcp = calculateLCP(str, suffixArray);

        // The number of distinct substrings is the sum of the difference between the length of
        // each suffix and its corresponding lcp with previous suffix. This is because all
        // substrings that are prefixes of the lcp have been counted.
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += (n-suffixArray[i]) - lcp[i];

        out.println(sum);
    }

    /**
     * Calculate the length of longest common prefix for consecutive suffixes
     *
     * @return an array containing the lengths of longest common prefix for the given suffix array.
     */
    private int[] calculateLCP(char[] str, Integer[] suffixArray) {
        int n = str.length;
        int[] lcp = new int[n];

        for (int i = 1; i < n; i++) {
            // Calculate the length of the longest common prefix between (i-1)-th and i-th suffixes
            int index1 = suffixArray[i-1], index2 = suffixArray[i];
            while (index1 < n && index2 < n && str[index1++] == str[index2++])
                lcp[i]++;
        }

        return lcp;
    }
}
