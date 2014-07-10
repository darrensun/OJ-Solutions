package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Timus 1563 - Bayan
 * Created by Darren on 14-7-10.
 */
public class Q1563 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());
            Set<String> brands = new HashSet<String>(); // Record brands that have been visited
            int duplicates = 0;
            for (int i = 0; i < n; i++) {
                String brand = in.readLine();
                if (brands.contains(brand))     // The brand has been visited before
                    duplicates++;
                else        // New brand, visit it for the first time
                    brands.add(brand);
            }
            System.out.println(duplicates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
