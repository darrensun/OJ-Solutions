package com.darrensun.spoj.buglife;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * SPOJ 3377 - A Bug’s Life
 * Created by Darren on 14-8-6.
 * Solved by DFS.
 * The idea is to find if there is any cycle of odd length.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);
    static final String SCENARIO = "Scenario #%d:\n";
    static final String FOUND = "Suspicious bugs found!";
    static final String NOT_FOUND = "No suspicious bugs found!";

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = in.nextInt();
        for (int i = 1; i <= testcases; i++)
            solve(i);
        out.flush();
    }

    private static int n, m;
    private static boolean[][] graph = new boolean[2001][2001]; // Static for space reuse
    private static byte[] sex = new byte[2001];

    void solve(int testcase) throws IOException {
        constructGraph();
        out.printf(SCENARIO, testcase);

        boolean status = true;  // true if no homosexual interaction is found
        for (int i = 1; status && i <= n; i++) {    // Jump out of the loop as long as status=false
            if (sex[i] == 0) {
                sex[i] = 1;
                status = dfs(i);
            }
        }

        if (status)
            out.println(NOT_FOUND);
        else
            out.println(FOUND);
    }

    // Construct a graph based on the input
    void constructGraph() throws IOException {
        n = in.nextInt();
        m = in.nextInt();

        // Initialize graph[][] and sex[]
        for (int i = 1; i <= n; i++)
            Arrays.fill(graph[i], 1, n+1, false);
        Arrays.fill(sex, 1, n+1, (byte)0);

        // Read edges
        int u, v;
        for (int j = 0; j < m; j++) {
            u = in.nextInt();
            v = in.nextInt();
            graph[u][v] = graph[v][u] = true;
        }
    }

    // DFS traversal whose return value indicates whether a cycle of odd length (i.e., containing
    // a homosexual interaction) has been found (false -> found).
    boolean dfs(int u) {
        for (int v = 1; v <= n; v++) {
            if (!graph[u][v])   // Consider adjacent vertices only
                continue;
            if (sex[v] == 0) {  // New vertex
                sex[v] = (byte)-sex[u];     // Assigned the opposite sex as u's
                if (!dfs(v))    // Terminate as long as a homosexual interaction has been found
                    return false;
            } else if (sex[v]+sex[u] != 0) {    // Interaction between homosexual bugs
                return false;
            }
        }
        return true;
    }

    /**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 65536;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws java.io.IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }

        /**
         * Read a line of data from the input stream.
         * @return the next line of data.
         * @throws IOException if an I/O error occurs.
         */
        public String readLine() throws IOException {
            StringBuilder line = new StringBuilder();
            char c;
            while ((c = (char)(read())) != '\n') {
                line.append(c);
            }
            return line.toString();
        }

        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }
}
