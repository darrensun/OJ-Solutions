package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Tims 1991 - The battle near the swamp
 * Created by Darren on 14-7-10.
 */
public class Q1991 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(in.readLine());
            int unusedBombs = 0, survivals = 0;
            for (int i = 0; i < n; i++) {
                int bombs = Integer.parseInt(tokenizer.nextToken());
                if (bombs <= k)
                    survivals += k - bombs;
                else
                    unusedBombs += bombs - k;
            }
            System.out.println(String.format("%d %d", unusedBombs, survivals));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
