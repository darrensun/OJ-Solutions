package com.darrensun.spoj.etf;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 4141 - Euler Totient Function
 * Created by Darren on 14-7-22.
 * Euler's totient function: phi(n) = n * (1-1/p_1) * ... * (1-1/p_k)
 * The judge is unfriendly to Java solutions due to the stringent time limit. The same idea with
 * C/C++ can get accepted.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    void run() throws Exception {
        int testcases = in.nextInt();
        while (testcases-- > 0)
            out.println(eulerTotientFunction(in.nextInt()));
        out.flush();
    }

    /**
     * Calculate Euler's totient function of a given integer.
     * @param n the given integer
     * @return the value of the Euler's totient function of n.
     */
    int eulerTotientFunction(int n) {
        int result = n;
        for (int i = 2; i <= n/i; i++) {
            if (n % i == 0)
                result -= result / i;
            while (n % i == 0)
                n /= i;
        }
        if (n > 1)
            result -= result / n;
        return result;
    }

    /**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 1 << 20;  // 2^16, a good compromise for some problems
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
         * @throws IOException
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
