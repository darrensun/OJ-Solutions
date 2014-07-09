package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Timus 1100 - Final Standings
 * Created by Darren on 14-7-9.
 * Adapted from bucket sort. The key point is to use an efficient "STABLE" sorting algorithm.
 */
public class Q1100 {

    public final static int TOTAL_QUESTIONS = 100;

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            List<List<Integer>> buckets = new ArrayList<List<Integer>>();
            for (int i = 0; i <= TOTAL_QUESTIONS; i++)
                buckets.add(new ArrayList<Integer>());
            for (int i = 0; i < n; i++) {
                StringTokenizer tokenizer = new StringTokenizer(in.readLine());
                int id = Integer.parseInt(tokenizer.nextToken());
                int problemSolved = Integer.parseInt(tokenizer.nextToken());
                buckets.get(problemSolved).add(id);
            }
            PrintWriter out = new PrintWriter(System.out);
            for (int i = TOTAL_QUESTIONS; i >= 0; i--) {
                for (int j : buckets.get(i)) {
                    out.print(j);
                    out.print(' ');
                    out.println(i);
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
