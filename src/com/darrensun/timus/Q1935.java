package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Timus 1935 - Tears of Drowned
 * Created by Darren on 14-7-10.
 * Optimal strategy: arrange the skins in order (either ascending or descending)
 * The optimality can be proved by contradiction.
 */
public class Q1935 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            int[] margins = new int[n];
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < n; i++)
                margins[i] = Integer.parseInt(tokenizer.nextToken());
            Arrays.sort(margins);   // Sort the array in non-descending order
            int sheets = margins[n-1];
            for (int i = 0; i < n; i++)
                sheets += margins[i];
            System.out.println(sheets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
