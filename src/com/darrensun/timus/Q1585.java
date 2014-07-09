package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Timus 1585 - Penguins
 * Created by Darren on 14-7-9.
 */
public class Q1585 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            int emperor = 0, little = 0, macaroni = 0;
            // Count the number of each penguin
            for (int i = 0; i < n; i++) {
                char initial = in.readLine().charAt(0);
                if (initial == 'E')
                    emperor++;
                else if (initial == 'L')
                    little++;
                else
                    macaroni++;
            }
            // Output the species with the most number
            if (emperor > little && emperor > macaroni)
                System.out.println("Emperor Penguin");
            else if (little > emperor && little > macaroni)
                System.out.println("Little Penguin");
            else
                System.out.println("Macaroni Penguin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
