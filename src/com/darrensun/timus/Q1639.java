package com.darrensun.timus;

import java.util.Scanner;

/**
 * Timus 1639 - Chocolate 2
 * Created by Darren on 14-7-8.
 * The number of moves is constant: m*n-1
 * Why? We can model the separation process as a tree, and it turns out to be a full binary tree,
 * i.e., each node has either two children or none. There must be m*n leaves or external nodes,
 * and thus the number of internal nodes is m*n-1 (why again). Each internal node correspond to a
 * move in the game.
 */
public class Q1639 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if ((m*n-1 & 1) == 1)   // Odd number of moves
            System.out.println("[:=[first]");
        else        // Even number of moves
            System.out.println("[second]=:]");
    }
}
