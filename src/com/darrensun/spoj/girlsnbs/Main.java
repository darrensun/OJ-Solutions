package com.darrensun.spoj.girlsnbs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SPOJ 7424 - Girls and Boys
 * Created by Darren on 14-7-18.
 * Assuming g > b, the way to minimize the gender regularity is to separate girls with boys as
 * evenly as possible. In this case, the gender regularity would be ceil(g/(b+1))
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int girls = Integer.parseInt(tokenizer.nextToken());
            int boys = Integer.parseInt(tokenizer.nextToken());
            if (girls == -1 && boys == -1)
                break;
            solve(girls, boys);
        }
        out.flush();
    }

    void solve(int girls, int boys) {
        if (boys > girls) {
            solve(boys, girls);
            return;
        }
        out.println((int) Math.ceil(girls/(boys+1.0)));
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
