package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1149 - Sinus Dances
 * Created by Darren on 14-7-10.
 */
public class Q1149 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // Generate a_i based on a_{i-1}, s_i based on s_{i-1} and a_{i}
        StringBuilder a_i = new StringBuilder("sin(1)");
        StringBuilder s_i = new StringBuilder("sin(1)+1");
        for (int i = 2; i <= n; i++) {
            a_i.insert(a_i.length()-i+1, String.format("%csin(%d)", (i&1)==0 ? '-' : '+', i));
            s_i.insert(0, '(');
            s_i.insert(s_i.length()-2, String.format("+%d)%s", n-i+2, a_i.toString()));
        }

        System.out.println(s_i.toString());
    }
}
