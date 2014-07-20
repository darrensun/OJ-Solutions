package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1139 - City Blocks
 * Created by Darren on 14-7-11.
 * n: number of blocks horizontally
 * m: number of blocks vertically
 * Case 1: m and n are relatively prime. Then the route will not pass any "intersection point",
 * i.e., common point of four blocks, except the starting and ending points. As a result,
 * the route must enter a block from either left or bottom edge. On the other hand,
 * every time the route encounter a street (either in horizontal or vertical direction),
 * it will enter a new block. Therefore, including the starting block,
 * the number of blocks the route passes is (n-1)+(m-1)+1 = n+m-1.
 * Case 2: m and n are not relatively prime. Suppose f=gcd(m,n) > 1, a = n/f,
 * b = m/f. Then the route arrives at an intersection point every a blocks horizontally and b
 * blocks vertically. So the problem is reduced to f same subproblems of size a and b,
 * which essentially fall in the former case. The answer will be (a+b-1)*f.
 */
public class Q1139 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt()-1, m = in.nextInt()-1;
        int factor = gcd(n, m);
        n /= factor;
        m /= factor;
        System.out.println((n+m-1)*factor);
    }

    /**
     * Find the greatest common divisor of two non-negative integers.
     * @param m An integer.
     * @param n Another integer.
     * @return The greatest common divisor of m and n.
     */
    public static int gcd(int m, int n) {
        while (n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
