package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1902 - Neo-Venice
 * Created by Darren on 14-7-11.
 * (x-s)+(x-s_i)=t
 */
public class Q1902 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int t = Integer.parseInt(tokenizer.nextToken());
            int s = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(in.readLine());

            for (int i = 0; i < n; i++) {
                int s_i = Integer.parseInt(tokenizer.nextToken());
                System.out.printf("%.6f\n", (t+s+s_i)/2.0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
