package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Timus 1617 - Flat Spots
 * Created by Darren on 14-7-10.
 */
public class Q1617 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());

            // Count the number of pairs of wheels of the same size
            Map<Integer, Integer> stat = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                int diameter = Integer.parseInt(in.readLine());
                if (stat.containsKey(diameter))
                    stat.put(diameter, stat.get(diameter)+1);
                else
                    stat.put(diameter, 1);
            }

            // Four pairs of wheels of the same size make up a car
            int numOfCars = 0;
            for (Integer wheels : stat.values())
                numOfCars += wheels / 4;

            System.out.println(numOfCars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
