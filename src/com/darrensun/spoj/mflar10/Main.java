package com.darrensun.spoj.mflar10;

import java.io.*;
import java.util.StringTokenizer;

/**
 * SPOJ 7757 - Flowers Flourish from France
 * Created by Darren on 14-8-3.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        String line;
        while (!(line = in.readLine()).equals("*"))
            solve(line);
        out.flush();
    }

    void solve(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);

        // Get the initial of the first word, and convert it to its lower case if it is not
        char initial = tokenizer.nextToken().charAt(0);
        if (initial < 97)
            initial += 32;

        while (tokenizer.hasMoreTokens()) {
            char newInitial = tokenizer.nextToken().charAt(0);
            if (newInitial != initial && newInitial != initial-32) {    // Different initials
                out.println('N');
                return;
            }
        }

        out.println('Y');
    }
}
