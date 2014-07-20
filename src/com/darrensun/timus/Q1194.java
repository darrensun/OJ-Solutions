package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1194 - Handshakes
 * Created by Darren on 14-7-11.
 */
public class Q1194 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            in.readLine();
            int totalHandshakes = 0;
            String line;
            while ((line = in.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                tokenizer.nextToken();
                int numOfGroups = Integer.parseInt(tokenizer.nextToken());
                int[] subGroup = new int[numOfGroups];
                for (int i = 0; i < numOfGroups; i++) {
                    tokenizer.nextToken();
                    subGroup[i] = Integer.parseInt(tokenizer.nextToken());
                }
                totalHandshakes += numOfHandshakes(subGroup);
            }
            System.out.println(totalHandshakes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int numOfHandshakes(int[] subGroup) {
        int num = 0;
        for (int i = 0; i < subGroup.length-1; i++) {
            for (int j = i+1; j < subGroup.length; j++) {
                num += subGroup[i] * subGroup[j];
            }
        }
        return num;
    }
}
