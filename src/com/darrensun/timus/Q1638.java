package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1638 - Bookworm
 * Created by Darren on 14-7-11.
 * The author implicitly assume that when a book is put on the shelf,
 * its first sheet appears on the right of its last sheet.
 */
public class Q1638 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int volume = in.nextInt();
        int cover = in.nextInt();
        int startVolume = in.nextInt();
        int endVolume = in.nextInt();
        if (endVolume > startVolume)
            System.out.println(2*cover+(cover*2+volume)*(endVolume-startVolume-1));
        else
            System.out.println(volume+(cover*2+volume)*(startVolume-endVolume));
    }
}
