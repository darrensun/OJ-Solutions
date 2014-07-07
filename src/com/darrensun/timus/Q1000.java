package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Timus 1000 - A+B Problem
 * Created by Darren on 14-7-5.
 */
public class Q1000 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            PrintWriter out = new PrintWriter(System.out);
            out.println(a+b);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
