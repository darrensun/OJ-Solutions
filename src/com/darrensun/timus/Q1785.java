package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1785 - Lost in Localization
 * Created by Darren on 14-7-8.
 */
public class Q1785 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        if (amount <= 4)
            System.out.println("few");
        else if (amount <= 9)
            System.out.println("several");
        else if (amount <= 19)
            System.out.println("pack");
        else if (amount <= 49)
            System.out.println("lots");
        else if (amount <= 99)
            System.out.println("horde");
        else if (amount <= 249)
            System.out.println("throng");
        else if (amount <= 499)
            System.out.println("swarm");
        else if (amount <= 999)
            System.out.println("zounds");
        else
            System.out.println("legion");
    }
}
