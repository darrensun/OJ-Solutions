package com.darrensun.spoj.hotels;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 9861 - Hotels Along the Croatian Coast
 * Created by Darren on 14-8-4.
 * Solved by a local-global greedy algorithm, with O(n) time and O(1) extra space.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private int n, m;
    private int[] values;

    void run() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        values = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = in.nextInt();

        int globalMax = 0;
        long localMax = 0;  // Possible to overflow with int
        int left = 0, right = 0;
        while (right < n) {
            // Update local maximum
            localMax += values[right++];
            while (localMax > m && left < right)
                localMax -= values[left++];
            // Update global maximum
            globalMax = (globalMax < localMax) ? (int)localMax : globalMax;
            if (globalMax == m) {   // The best possible outcome we can achieve
                out.println(globalMax);
                return;
            }
        }
        out.println(globalMax);
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
