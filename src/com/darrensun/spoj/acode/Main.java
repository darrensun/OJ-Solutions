package com.darrensun.spoj.acode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 394 - Alphacode
 * Created by Darren on 14-7-16.
 * Solved by dynamic programming.
 * C(i): the number of decoding for cipher[i...n-1] assuming cipher's length is n.
 * C(i) =
 *  1. 0, if cipher[i] = '0';   // Pay special attention to this case
 *  2. C(i+1)+C(i+2), if cipher[i] == '1' or (cipher[i] == '2' and cipher[i+1] <= '6')
 *  3. C(i+1), otherwise.
 * C(n) = 1, C(n-1) = 0 if cipher[n-1] == '0', or 1 otherwise.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String cipher;
        while (!(cipher = in.readLine()).equals("0"))
            out.println(numOfDecoding(cipher));
        out.flush();
    }

    /**
     * Find the number of different decodings given a cipher.
     * @param cipher The given cipher.
     * @return The number of different decodings of the cipher.
     */
    public static long numOfDecoding(String cipher) {
        long d0 = 1, d1 = cipher.charAt(cipher.length()-1)=='0' ? 0 : 1;
        for (int i = cipher.length()-2; i >= 0; i--) {
            if (cipher.charAt(i) == '0') {  // Do not leave out this case!
                d0 = d1;
                d1 = 0;
            } else {
                long temp = d1;
                if (cipher.charAt(i) == '1' || cipher.charAt(i) == '2' && cipher.charAt(i+1) <= '6')
                    temp += d0;
                d0 = d1;
                d1 = temp;
            }
        }
        return d1;
    }
}
