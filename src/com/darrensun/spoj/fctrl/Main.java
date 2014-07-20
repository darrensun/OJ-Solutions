package com.darrensun.spoj.fctrl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ 11 -  Factorial
 * Created by Darren on 14-7-14.
 * For the prime decomposition of n!, only 2 and 5 contribute to a trailing zero. That is,
 * every 5 successive numbers contribute to at least a zero. So we divide the n numbers into n/5
 * groups g_1,..., g_{n/5}, each containing 5 successive numbers and leaving out those large
 * numbers insufficient to form a group. Now n! can be represented as
 * 10^{n/5} * (g_1/10)*...*(g_{n/5}/10). It turns out that every 5 succesive groups contain a
 * factor of 5 and contribute to at least a zero. The similar process is then applied to the
 * groups, until there are less than 5 groups left.
 *
 * In summary, z(n)=\sum_{i=1}^{log_5 n} \lfloor n/5^k \rfloor.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());

        for (int i = 0; i < testcases; i++) {
            int n = Integer.parseInt(in.readLine());
            int trailingZeroes = 0;
            while (n > 0) {
                n /= 5;
                trailingZeroes += n;
            }
            out.println(trailingZeroes);
        }
        out.flush();
    }
}
