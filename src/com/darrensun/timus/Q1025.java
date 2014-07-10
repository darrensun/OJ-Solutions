package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Timus 1025 - Democracy in Danger
 * Created by Darren on 14-7-10.
 * Getting "For" from k/2+1 groups guarantees a "For" for any decision.
 * To have minimum supporters that achieve "For", arrange slightly more than half supporters in
 * the smallest k/2+1 groups.
 */
public class Q1025 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int k = Integer.parseInt(in.readLine());
            int[] votersWithinGroup = new int[k];
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < k; i++)
                votersWithinGroup[i] = Integer.parseInt(tokenizer.nextToken());
            Arrays.sort(votersWithinGroup); // Sort the array in non-descending order
            int minimumSupporters = 0;
            for (int i = 0; i <= k/2; i++)
                minimumSupporters += votersWithinGroup[i] / 2 + 1;
            System.out.println(minimumSupporters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
