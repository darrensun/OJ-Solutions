package com.darrensun.spoj.anarc05b;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 4560 - The Double HeLiX
 * Created by Darren on 14-7-26.
 * Solved by a greedy algorithm, with O(m+n) time and O(m+n) space.
 * At each intersection, choose the sequence with a larger sum of the numbers between
 * this intersection and the next intersection.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    // static variable for space reuse
    private static int[] first = new int[10000];
    private static int[] second = new int[10000];

    void run() throws IOException {
        int m, n;
        while ((m = in.nextInt()) != 0) {
            for (int i = 0; i < m; i++)
                first[i] = in.nextInt();
            n = in.nextInt();
            for (int i = 0; i < n; i++)
                second[i] = in.nextInt();
            solve(m, n);
        }
        out.flush();
    }

    void solve(int m, int n) {
        // Sum of the numbers between adjacent intersections in sequence first and second,
        // respectively, and the maximum sum of the numbers in the walking path selected
        int sumFirst = 0, sumSecond = 0, sumMax = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (first[i] == second[j]) {    // Intersection
                sumMax += first[i] + ((sumFirst >= sumSecond) ? sumFirst : sumSecond);
                sumFirst = sumSecond = 0;
                i++;
                j++;
            }
            // The next intersection value is larger than the smaller one
            else if (first[i] < second[j]) {
                sumFirst += first[i];
                i++;
            } else {
                sumSecond += second[j];
                j++;
            }
        }

        // No more intersections; sum up the remaining numbers in one of the sequence
        while (i < m)
            sumFirst += first[i++];
        while (j < n)
            sumSecond += second[j++];

        // At the last intersection, select the sequence with the larger sum of numbers after it
        sumMax += (sumFirst >= sumSecond) ? sumFirst : sumSecond;

        out.println(sumMax);
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
