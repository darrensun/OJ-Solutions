package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1881 - Long problem statement
 * Created by Darren on 14-7-9.
 */
public class Q1881 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int h = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            int n = Integer.parseInt(tokenizer.nextToken());
            int remainingSpaceInALine = 0, linesUsed = 0;
            for (int i = 0; i < n; i++) {
                int wordLength = in.readLine().length();
                if (wordLength <= remainingSpaceInALine) {
                    remainingSpaceInALine -= wordLength + 1;
                } else {
                    linesUsed++;
                    remainingSpaceInALine = w - (wordLength + 1);
                }
            }
            System.out.println((linesUsed+h-1)/h);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
