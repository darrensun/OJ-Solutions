package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1925 - British Scientists Save the World
 * Created by Darren on 14-7-9.
 */
public class Q1925 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            int accumualation = 0;
            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(in.readLine());
                int b = Integer.parseInt(tokenizer.nextToken());
                int g = Integer.parseInt(tokenizer.nextToken());
                accumualation += b - g - 2;
            }
            int key = k - 2 + accumualation;
            if (key > 0)
                System.out.println(key);
            else
                System.out.println("Big Bang!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
