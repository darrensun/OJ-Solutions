package com.darrensun.spoj.acpc11b;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * SPOJ 10239 - Between the Mountains
 * Created by Darren on 14-7-29.
 * Solved by presorting.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            solve();
        }
        out.flush();
    }

    private static int[] alt1 = new int[1000];
    private static int[] alt2 = new int[1000];

    void solve() throws IOException {
        // Read altitudes of the two mountains
        int m = in.nextInt();
        for (int i = 0; i < m; i++)
            alt1[i] = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++)
            alt2[i] = in.nextInt();

        // Sort the altitudes of the mountains, individually
        Arrays.sort(alt1, 0, m);
        Arrays.sort(alt2, 0, n);

        // Find their minimum difference
        int minDifference = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (minDifference > Math.abs(alt1[i]-alt2[j]))
                minDifference = Math.abs(alt1[i]-alt2[j]);
            if (alt1[i] == alt2[j]) // minDifference = 0, the least possible already
                break;
            if (alt1[i] < alt2[j])
                i++;
            else
                j++;
        }

        out.println(minDifference);
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
