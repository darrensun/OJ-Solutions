package com.darrensun.spoj.tricount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 1724 - Counting Triangles
 * Created by Darren on 14-7-16.
 * OEIS page for 1, 5, 13, 27... : http://oeis.org/A002717
 * For another form of the formulation, see http://math.stackexchange.com/questions/203873/how-many-triangles
 * Do not leave out downward triangles.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            long n = Long.parseLong(in.readLine());
            out.println(n*(n+2)*((n<<1)+1)>>3);
        }
        out.flush();
    }
}
