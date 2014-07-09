package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Timus 1880 - Psych Up's Eigenvalues
 * Created by Darren on 14-7-8.
 * Conduct a 3-way search on the eigenvalues.
 */
public class Q1880 {
    private int player1, player2, player3;
    private int[] eigenvalues1, eigenvalues2, eigenvalues3;

    public Q1880() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = null;

        // Read eigenvalues for player 1
        player1 = Integer.parseInt(in.readLine());
        eigenvalues1 = new int[player1];
        tokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < player1; i++)
            eigenvalues1[i] = Integer.parseInt(tokenizer.nextToken());

        // Read eigenvalues for player 2
        player2 = Integer.parseInt(in.readLine());
        eigenvalues2 = new int[player2];
        tokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < player2; i++)
            eigenvalues2[i] = Integer.parseInt(tokenizer.nextToken());

        // Read eigenvalues for player 3
        player3 = Integer.parseInt(in.readLine());
        eigenvalues3 = new int[player3];
        tokenizer = new StringTokenizer(in.readLine());
        for (int i = 0; i < player3; i++)
            eigenvalues3[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void main(String[] args) {
        try {
            Q1880 q1880 = new Q1880();
            System.out.println(q1880.numOfTeamEigenvalues());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find the number of eigenvalues each player has.
     * @return The number of eigenvalues each player has.
     */
    public int numOfTeamEigenvalues() {
        int i = 0, j = 0, k = 0;
        int count = 0;
        while (i < player1 && j < player2 && k < player3) {
            // A common eigenvalue is found
            if (eigenvalues1[i] == eigenvalues2[j] && eigenvalues2[j] == eigenvalues3[k]) {
                count++;
                i++;
                j++;
                k++;
            }
            // Increment the index of the player with the smallest eigenvalue among the ones of
            // the current comparison
            else if (eigenvalues1[i] <= eigenvalues2[j] && eigenvalues1[i] <= eigenvalues3[k]) {
                i++;
            } else if (eigenvalues2[j] <= eigenvalues3[k] && eigenvalues2[j] <= eigenvalues1[i]) {
                j++;
            } else {
                k++;
            }
        }
        return count;
    }
}
