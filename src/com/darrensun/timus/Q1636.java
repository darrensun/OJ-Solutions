package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1636 - Penalty Time
 * Created by Darren on 14-7-10.
 */
public class Q1636 {
    public final static String NO_CHANCE = "No chance.";
    public final static String DIRTY_DEBUG = "Dirty debug :(";
    public final static int NUM_OF_PROBLEMS = 10;
    public final static int PENALTY = 20;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int t1 = Integer.parseInt(tokenizer.nextToken());
            int t2 = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < NUM_OF_PROBLEMS; i++) {
                int rejectedTimes = Integer.parseInt(tokenizer.nextToken());
                t2 -= PENALTY * rejectedTimes;
                if (t1 > t2)
                    break;
            }
            System.out.println((t1 <= t2) ? NO_CHANCE : DIRTY_DEBUG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
