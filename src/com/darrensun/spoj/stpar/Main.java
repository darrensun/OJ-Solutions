package com.darrensun.spoj.stpar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * SPOJ 95 - Street Parade
 * Created by Darren on 14-7-17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n;
        Deque<Integer> sideStreet = new ArrayDeque<Integer>();
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int target = 1;
            while (n-- > 0) {
                int current = Integer.parseInt(tokenizer.nextToken());
                if (current == target) {    // Current truck matches the target
                    target++;
                } else if (sideStreet.peek() == null || sideStreet.peek() > current) {
                    // Empty side street, or the first truck in the side street should come after
                    // the current one
                    sideStreet.push(current);
                } else if (sideStreet.peek() == target) {
                    // Truck(s) in the side street matches the target
                    do {
                        sideStreet.pop();
                        target++;
                    } while (sideStreet.peek() != null && sideStreet.peek() == target);
                    sideStreet.push(current);
                } else {    // Current truck should come before the first one in the side street
                    out.println("no");
                    break;
                }
            }
            if (n < 0)  // Not exit by loop break
                out.println("yes");
            sideStreet.clear();
        }
        out.flush();
    }
}
