package com.darrensun.timus;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Timus 1792 - Hamming Code
 * Created by Darren on 14-7-10.
 */
public class Q1792 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] code = new int[8];
        for (int i = 1; i <= 7; i++)
            code[i] = in.nextInt();
        int errorCode = 0;
        errorCode += (code[2]^code[3]^code[4]^code[5]) << 2;
        errorCode += (code[1]^code[3]^code[4]^code[6]) << 1;
        errorCode += (code[1]^code[2]^code[4]^code[7]);
        switch (errorCode) {
            case 0 : break; // 000
            case 1 : code[7] = 1 - code[7]; break;  // 001;
            case 2 : code[6] = 1 - code[6]; break;  // 010
            case 3 : code[1] = 1 - code[1]; break;  // 011
            case 4 : code[5] = 1 - code[5]; break;  // 100
            case 5 : code[2] = 1 - code[2]; break;  // 101
            case 6 : code[3] = 1 - code[3]; break;  // 110
            case 7 : code[4] = 1 - code[4]; break;  // 111
        }
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 1; i <= 7; i++) {
            out.print(code[i]);
            out.print(' ');
        }
        out.flush();
    }
}
