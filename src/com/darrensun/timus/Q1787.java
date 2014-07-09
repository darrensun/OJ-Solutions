package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1787 - Turn for MEGA
 * Created by Darren on 14-7-8.
 */
public class Q1787 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(in.readLine());
        int standing = 0;
        for (int i = 0; i < n; i++) {
            standing += Integer.parseInt(tokenizer.nextToken()) - k;
            if (standing < 0)
                standing = 0;
        }
        System.out.println(standing);
    }
}
