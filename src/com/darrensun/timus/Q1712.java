package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Timus 1712 - Cipher Grille
 * Created by Darren on 14-7-10.
 */
public class Q1712 {
    public final static int SIZE = 4;

    class Window {
        int row;
        int column;

        public Window(int i, int j) {
            this.row = i;
            this.column = j;
        }
    }

    private BufferedReader in;
    private Window[] windows;

    public Q1712() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        windows = new Window[SIZE];
        // Get the position of the four windows
        int k = 0;
        for (int i = 0; i < SIZE; i++) {
            String line = in.readLine();
            for (int j = 0; j < SIZE; j++) {
                if (line.charAt(j) == 'X')
                    windows[k++] = new Window(i, j);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Q1712 q1712 = new Q1712();
            System.out.println(q1712.decipher());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Decipher the password with the grille.
     * @return The deciphered password.
     * @throws IOException If the input format is not correct.
     */
    public String decipher() throws IOException {
        char[][] cipher = readCipher();
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            // Sort the windows in the row-major manner
            Arrays.sort(windows, new Comparator<Window>() {
                @Override
                public int compare(Window w1, Window w2) {
                    if (w1.row != w2.row)
                        return w1.row - w2.row;
                    return w1.column - w2.column;
                }
            });
            // Add the visible characters under the windows to the deciphered message
            for (int j = 0; j < SIZE; j++)
                message.append(cipher[windows[j].row][windows[j].column]);
            // Rotate the grille clockwise by 90 degrees
            rotateGrille();
        }
        return message.toString();
    }

    /**
     * Read ciphered password from standard input.
     * @return A four-by-four character matrix containing the ciphered password
     * @throws IOException If the input format is not correct.
     */
    private char[][] readCipher() throws IOException {
        char[][] cipher = new char[SIZE][];
        for (int i = 0; i < SIZE; i++)
            cipher[i] = in.readLine().toCharArray();
        return cipher;
    }

    /**
     * Rotate the grille clockwise by 90 degrees.
     */
    private void rotateGrille() {
        // For each window (row, column), it becomes (column, 4-row-1)
        for (int i = 0; i < SIZE; i++) {
            int temp = windows[i].row;
            windows[i].row = windows[i].column;
            windows[i].column = SIZE - temp - 1;
        }
    }
}
