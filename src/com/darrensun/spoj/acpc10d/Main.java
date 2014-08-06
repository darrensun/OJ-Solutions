package com.darrensun.spoj.acpc10d;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 7975 - Tri graphs
 * Created by Darren on 14-8-6.
 * Solved by DP with O(n) time and O(1) space.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private int n;

    void run() throws IOException {
        int testcase = 1;
        while ((n = in.nextInt()) > 0)
            solve(testcase++);
        out.flush();
    }

    void solve(int testcase) throws IOException {
        int[][] vertices = new int[2][3];
        // Get the value of the top-middle vertex
        in.nextInt();
        vertices[0][0] = Integer.MAX_VALUE;
        vertices[0][1] = in.nextInt();
        vertices[0][2] = vertices[0][1] + in.nextInt();

        // Main body of DP; note the flow directions
        int row = 1;
        int temp1, temp2;
        for (int i = 0; i < n-1; i++) {
            temp1 = Math.min(vertices[row^1][0], vertices[row^1][1]);
            temp2 = Math.min(vertices[row^1][1], vertices[row^1][2]);
            vertices[row][0] = temp1 + in.nextInt();
            vertices[row][1] = Math.min(vertices[row][0], Math.min(temp1, temp2)) + in.nextInt();
            vertices[row][2] = Math.min(vertices[row][1], temp2) + in.nextInt();
            row ^= 1;
        }

        out.print(testcase);
        out.print(". ");
        out.println(vertices[row^1][1]);
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
