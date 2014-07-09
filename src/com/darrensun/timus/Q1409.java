package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1409 - Two Gangsters
 * Created by Darren on 14-7-8.
 * The number of cans = the one shooted by harry + the one shooted by larry - 1
 */
public class Q1409 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int harry = in.nextInt();
        int larry = in.nextInt();
        System.out.println(String.format("%d %d", larry-1, harry-1));
    }
}
