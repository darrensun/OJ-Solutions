package com.darrensun.spoj.permut2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 379 - Ambiguous Permutations
 * Created by Darren on 14-7-16.
 * A permutation is ambiguous if and only if for each i, permutaion[permutaion[i]] = i.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n;
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            int[] permutation = new int[n+1];
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int i = 1; i <= n; i++)
                permutation[i] = Integer.parseInt(tokenizer.nextToken());
            boolean isAmbiguous = true;
            for (int i = 1; i <= n; i++) {
                if (permutation[permutation[i]] != i) {
                    isAmbiguous = false;
                    out.println("not ambiguous");
                    break;
                }
            }
            if (isAmbiguous)
                out.println("ambiguous");
        }
        out.flush();
    }
}
