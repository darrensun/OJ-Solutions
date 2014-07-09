package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1893 - A380
 * Created by Darren on 14-7-9.
 */
public class Q1893 {
    public static String WINDOW = "window";
    public static String AISLE = "aisle";
    public static String NEITHER = "neither";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String seat = in.nextLine();
        int row = Integer.parseInt(seat.substring(0, seat.length()-1));
        char letter = seat.charAt(seat.length()-1);
        if (row <= 2) {
            if (letter == 'A' || letter == 'D')
                System.out.println(WINDOW);
            else
                System.out.println(AISLE);
        } else if (row <= 20) {
            if (letter == 'A' || letter == 'F')
                System.out.println(WINDOW);
            else
                System.out.println(AISLE);
        } else {
            if (letter == 'A' || letter == 'K')
                System.out.println(WINDOW);
            else if (letter == 'C' || letter == 'D' || letter == 'G' || letter == 'H')
                System.out.println(AISLE);
            else
                System.out.println(NEITHER);
        }
    }
}
