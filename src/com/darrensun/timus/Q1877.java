package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1877 - Bicycle Codes
 * Created by Darren on 14-7-8.
 * On odd nights, the first lock is used, and the thief uses even codes; on even nights,
 * the second lock is used, and the thief uses odd codes. The only possibility that the thief
 * will never open the lock is when the code of the first lock is odd,
 * and that of the second lock is even.
 */
public class Q1877 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lock1 = in.nextInt();
        int lock2 = in.nextInt();
        if ((lock1 & 1) == 1 && (lock2 & 1) == 0)
            System.out.println("no");
        else
            System.out.println("yes");
    }
}
