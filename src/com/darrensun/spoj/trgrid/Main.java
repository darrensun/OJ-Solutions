package com.darrensun.spoj.trgrid;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 5976 - Traversing Grid
 * Created by Darren on 14-7-31.
 * Move direction: outside-in
 * Each time the cells on the outer boundary have been traversed, we essentially repeat the same
 * process for a grid of smaller size, i.e., (n-2)*(m-2) if n>2 and m>2.
 * So just try on the grids one of whose dimensions is smaller than or equal to 2.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = in.nextInt();
        while (testcases-- > 0)
            solve(in.nextInt(), in.nextInt());
        out.flush();
    }

    void solve(int n, int m) {
        if (n <= m) {
            if ((n&1) == 1)
                out.println('R');
            else
                out.println('L');
        } else {
            if ((m&1) == 1)
                out.println('D');
            else
                out.println('U');
        }
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
