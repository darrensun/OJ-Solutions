package com.darrensun.spoj.ngm;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * SPOJ 1419 - A Game with Numbers
 * Created by Darren on 14-7-18.
 * Nikifor wins the game as long as the given integer is not a multiple of 10. Try numbers from
 * 1...20 and you will find the pattern.
 */
public class Main {
    Scanner in = new Scanner(System.in);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        int indicator = in.nextInt() % 10;
        if (indicator != 0) {
            out.println(1);
            out.println(indicator);
        } else {
            out.println(2);
        }
        out.flush();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
