package com.darrensun.spoj.army;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ 2727 - Army Strength
 * Created by Darren on 14-7-17.
 * No need to simulate the battle.
 * The army with the strongest monster among all monsters win the battle.
 */
public class Main {
    public final static String GODZILLA = "Godzilla";
    public final static String MECHAGODZILLA = "MechaGodzilla";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int ng = Integer.parseInt(tokenizer.nextToken());
            int nm = Integer.parseInt(tokenizer.nextToken());

            // Find the strongest monster for both armies
            int strongestOfGodzilla = 0;
            tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < ng; i++) {
                int strength = Integer.parseInt(tokenizer.nextToken());
                if (strength > strongestOfGodzilla)
                    strongestOfGodzilla = strength;
            }
            int strongestOfMechaGodzilla = 0;
            tokenizer = new StringTokenizer(in.readLine());
            for (int i = 0; i < nm; i++) {
                int strength = Integer.parseInt(tokenizer.nextToken());
                if (strength > strongestOfMechaGodzilla)
                    strongestOfMechaGodzilla = strength;
            }

            // The army with the strongest among all monsters win the battle
            if (strongestOfGodzilla >= strongestOfMechaGodzilla)
                out.println(GODZILLA);
            else
                out.println(MECHAGODZILLA);
        }
        out.flush();
    }
}
