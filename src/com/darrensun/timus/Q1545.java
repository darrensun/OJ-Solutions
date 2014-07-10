package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Timus 1545 - Hieroglyphs
 * Created by Darren on 14-7-10.
 * Use a hashmap to serve as a dictionary indexed by the initial letter.
 */
public class Q1545 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            Map<Character, List<String>> map = new HashMap<Character, List<String>>();
            for (int i = 0; i < n; i++) {
                String sequence = in.readLine();
                char initial = sequence.charAt(0);
                if (map.containsKey(initial)) {
                    map.get(initial).add(sequence);
                } else {
                    List<String> newList = new ArrayList<String>();
                    newList.add(sequence);
                    map.put(initial, newList);
                }
            }
            char currentInput = in.readLine().charAt(0);
            if (!map.containsKey(currentInput))
                return;
            PrintWriter out = new PrintWriter(System.out);
            for (String s : map.get(currentInput))
                out.println(s);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
