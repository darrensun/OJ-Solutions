package com.darrensun.spoj.pt07y;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * SPOJ 1436 - Is it a tree
 * Created by Darren on 14-7-17.
 * A graph is a tree if and only if the number of vertices exceeds that of edges by exactly one,
 * and there is no simple cycle.
 * The second part can be verified by the quick-union algorithm with path compression.
 * Of course, DFS/BFS is obviously another way to solve the problem.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        if (n != m+1) {
            out.println("NO");
        } else {
            int[] id = new int[n+1];
            for (int i = 1; i <= n; i++)
                id[i] = i;
            int j;
            for (j = 0; j < m; j++) {
                tokenizer = new StringTokenizer(in.readLine());
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());
                if (find(u, id) == find(v, id)) {
                    out.println("NO");
                    break;
                } else {
                    id[v] = id[u];
                }
            }
            if (j == m)
                out.println("YES");
        }
        out.flush();
    }

    private static int find(int x, int[] id) {
        while (x != id[x]) {
            id[x] = id[id[x]];  // Path compression
            x = id[x];
        }
        return x;
    }
}
