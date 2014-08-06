package com.darrensun.spoj.fibosum;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 8001 - Fibonacci Sum
 * Created by Darren on 14-8-1.
 * Solved with O(max{logn, logm}) time
 * The basic idea is to use the fact that the sum of the first n-th Fibonacci numbers is the
 * (n+2)-th number minus one.
 * Actual Fibonacci numbers are not necessary; we can apply modulo operation in each step to avoid
 * extremely large numbers.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);
    public final static int MODULOS = 1000000007;

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
        long sum1 = pow(n+1), sum2 = pow(m+2);
        out.println((sum2-sum1+MODULOS) % MODULOS); // Add MODULOS before the modulo operation
    }

    private static long[][] temp = new long[2][2];  // For space reuse

    // Calculate the n-th fibonacci number modulo MODULOS with O(logn) time
    long pow(int n) {
        long[][] matrix = new long[][] {{1, 0}, {0, 1}}, power = new long[][] {{1, 1}, {1, 0}};

        while (n != 0) {
            if ((n&1) == 1) {
                // Calculate matrix * power
                temp[0][0] = (matrix[0][0]*power[0][0] + matrix[0][1]*power[1][0]) % MODULOS;
                temp[0][1] = (matrix[0][0]*power[0][1] + matrix[0][1]*power[1][1]) % MODULOS;
                temp[1][0] = (matrix[1][0]*power[0][0] + matrix[1][1]*power[1][0]) % MODULOS;
                temp[1][1] = (matrix[1][0]*power[0][1] + matrix[1][1]*power[1][1]) % MODULOS;
                matrix[0][0] = temp[0][0];
                matrix[0][1] = temp[0][1];
                matrix[1][0] = temp[1][0];
                matrix[1][1] = temp[1][1];
            }

            // power = power * power
            temp[0][0] = (power[0][0]*power[0][0] + power[0][1]*power[1][0]) % MODULOS;
            temp[0][1] = (power[0][0]*power[0][1] + power[0][1]*power[1][1]) % MODULOS;
            temp[1][0] = (power[1][0]*power[0][0] + power[1][1]*power[1][0]) % MODULOS;
            temp[1][1] = (power[1][0]*power[0][1] + power[1][1]*power[1][1]) % MODULOS;
            power[0][0] = temp[0][0];
            power[0][1] = temp[0][1];
            power[1][0] = temp[1][0];
            power[1][1] = temp[1][1];

            n /= 2;
        }

        return matrix[0][1]-1;
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
