package com.darrensun.spoj.offside;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 2178 - He is offside!
 * Created by Darren on 14-7-18.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            if (a == 0 && d == 0)
                break;
            solve(a, d);
        }
        out.flush();
    }

    void solve(int a, int d) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int closestAttacker = Integer.MAX_VALUE;
        while (a-- > 0) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            closestAttacker = (distance < closestAttacker) ? distance : closestAttacker;
        }

        tokenizer = new StringTokenizer(in.readLine());
        int closestDefender = Integer.MAX_VALUE, secondClosestDefender = closestDefender;
        while (d-- > 0) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            if (distance <= closestDefender) {
                secondClosestDefender = closestDefender;
                closestDefender = distance;
            } else if (distance < secondClosestDefender) {
                secondClosestDefender = distance;
            }
        }

        // Compare the closest attacker and the second closest defender
        if (closestAttacker < secondClosestDefender)
            out.println('Y');
        else
            out.println('N');
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
