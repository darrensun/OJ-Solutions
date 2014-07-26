package com.darrensun.spoj.quadarea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 2716 - Maximal Quadrilateral Area
 * Created by Darren on 14-7-22.
 * Brahmagupta's formula: A = sqrt((s-a)*(s-b)*(s-c)*(s-d)), where s = (a+b+c+d)/2.
 * http://en.wikipedia.org/wiki/Brahmagupta's_formula
 * The area of a cyclic quadrilateral is the "maximum possible area" for any quadrilateral with the
 * given side lengths.
 * Note that the area might be unachievable due to the inability to form a cyclic quadrilateral
 * given the side lengths.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        double a = Double.parseDouble(tokenizer.nextToken());
        double b = Double.parseDouble(tokenizer.nextToken());
        double c = Double.parseDouble(tokenizer.nextToken());
        double d = Double.parseDouble(tokenizer.nextToken());
        double s = (a+b+c+d) / 2;
        out.printf("%.2f\n", Math.sqrt((s - a) * (s - b) * (s - c) * (s - d)));
    }
}
