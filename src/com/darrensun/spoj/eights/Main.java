package com.darrensun.spoj.eights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * SPOJ 1030 - Triple Fat Ladies
 * Created by Darren on 14-7-16.
 * Observation:
 *  1. The number must end with 2.
 *  2. Only the last three digits contribute to the last three digits of its cube.
 * thoseWithinThousand can be computed with a single loop of 99 iterations (12, 22, ..., 992)
 */
public class Main {
    // Only numbers within 1000 whose cubes end with 888
    private static int[] thoseWithinThousand = {192, 442, 692, 942};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int testcases = Integer.parseInt(in.readLine());
        for (int t = 0; t < testcases; t++) {
            long k = Long.parseLong(in.readLine());
            out.println(((k-1)>>2)*1000+thoseWithinThousand[(int)((k-1)&3)]);
        }
        out.flush();
    }
}
