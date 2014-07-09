package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus - Titan Ruins: Hidden Entrance
 * Created by Darren on 14-7-8.
 * Maintain a sliding window of size 3 and update the global maximum when needed.
 */
public class Q1910 {
    private int n;
    int[] sections;

    public Q1910() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        sections = new int[n+1];
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        for (int i = 1; i <= n; i++) {
            sections[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        try {
            Q1910 q1910 = new Q1910();
            q1910.findSpell();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find the position of the spell by one-pass scan of the sections.
     */
    public void findSpell() {
        assert n >= 3;
        int currentForce = sections[1] + sections[2] + sections[3]; // Window of size 3
        int maxForce = currentForce;
        int middleSection = 2;
        for (int i = 4; i <= n; i++) {
            currentForce += sections[i] - sections[i-3];    // Slide the window by 1
            if (currentForce > maxForce) {
                maxForce = currentForce;
                middleSection = i - 1;
            }
        }
        System.out.println(String.format("%d %d", maxForce, middleSection));
    }
}
