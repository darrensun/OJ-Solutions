package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 2005 - Taxi for Programmers
 * Created by Darren on 14-7-10.
 */
public class Q2005 {
    private int[][] distances;

    public Q2005() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        distances = new int[6][6];
        for (int i = 1; i <= 5; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            for (int j = 1; j <= 5; j++)
                distances[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    public static void main(String[] args) {
        try {
            Q2005 q2005 = new Q2005();
            q2005.findOptimalRoute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findOptimalRoute() {
        int[] route = new int[4];
        route[0] = distances[1][3]+distances[3][4]+distances[4][2]+distances[2][5];
        route[1] = distances[1][4]+distances[4][3]+distances[3][2]+distances[2][5];
        route[2] = distances[1][2]+distances[2][3]+distances[3][4]+distances[4][5];
        route[3] = distances[1][3]+distances[3][2]+distances[2][4]+distances[4][5];
        int optimalRoute = 0, shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (route[i] < shortestDistance) {
                shortestDistance = route[i];
                optimalRoute = i;
            }
        }
        System.out.println(shortestDistance);
        switch (optimalRoute) {
            case 0 : System.out.println("1 3 4 2 5"); break;
            case 1 : System.out.println("1 4 3 2 5"); break;
            case 2 : System.out.println("1 2 3 4 5"); break;
            case 3 : System.out.println("1 3 2 4 5"); break;
        }
    }
}
