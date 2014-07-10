package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Timus 1496 - Spammer
 * Created by Darren on 14-7-10.
 */
public class Q1496 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        try {
            int n = Integer.parseInt(in.readLine());
            Map<String, Integer> stat = new HashMap<String, Integer>();
            for (int i = 0; i < n; i++) {
                String name = in.readLine();
                if (stat.containsKey(name)) {
                    int frequency = stat.get(name);
                    if (frequency == 1)
                        out.println(name);
                    stat.put(name, frequency+1);
                } else {
                    stat.put(name, 1);
                }
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
