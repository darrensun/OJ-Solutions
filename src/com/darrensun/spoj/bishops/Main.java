package com.darrensun.spoj.bishops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * SPOJ 328 - Bishops
 * Created by Darren on 14-7-17.
 * C(n) = (n-1)*2 for n > 1; C(1) = 1
 * See more at http://mathworld.wolfram.com/BishopsProblem.html
 * My thought is that we can place n bishops in the first row, and place n-2 bishops in the
 * center of last row. But I am not sure how to prove that such placement is optimal.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line, one = "1";
        while ((line = in.readLine()) != null) {
            if (line.equals(one))
                out.println(one);
            else
                out.println((new BigInteger(line)).subtract(BigInteger.ONE).shiftLeft(1));
        }
        out.flush();
    }
}
