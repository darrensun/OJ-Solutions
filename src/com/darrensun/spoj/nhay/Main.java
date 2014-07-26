package com.darrensun.spoj.nhay;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

/**
 * SPOJ 32 - A Needle in the Haystack
 * Created by Darren on 14-7-24.
 * String matching by the KMP algorithm.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private int n;
    private byte[] pattern;
    private int[] prefixFunc;

    void run() throws IOException {
        while (true) {
            try {
                try {
                    n = in.nextInt();
                } catch (NoSuchElementException e) { // No more test case
                    break;
                }
                // Read the pattern
                pattern = new byte[n+1];
                for (int i = 1; i <= n; i++)
                    pattern[i] = in.read();
                in.read();  // Ignore '\n' at pattern

                // Execute a KMP match
                KMPMatcher();
            } catch (IOException e) {
                break;
            }
        }
        out.flush();
    }

    /**
     * Print the positions of the pattern's occurrance in the text, using the KMP algorithm.
     * @throws IOException if an I/O error occurs.
     */
    void KMPMatcher() throws IOException {
        computePrefixFunc();
        int q = 0;  // Number of characters matched.
        int position = 0;   // Position of current character.
        byte t;
        while ((t = in.read()) != '\n') {
            while (q > 0 && pattern[q+1] != t)  // Do not match the current character
                q = prefixFunc[q];
            if (pattern[q+1] == t)  // Match the current character
                q++;
            if (q == n) {   // A full match of the pattern
                out.println(position-n+1);
                q = prefixFunc[q];  // Look for the next match
            }
            position++;
        }
        out.println();
    }

    /**
     * Compute prefix function.
     */
    void computePrefixFunc() {
        prefixFunc = new int[n+1];
        int k = 0;
        for (int q = 2; q <= n; q++) {
            while (k > 0 && pattern[k+1] != pattern[q])
                k = prefixFunc[k];
            if (pattern[k+1] == pattern[q])
                k++;
            prefixFunc[q] = k;
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
         * @throws IOException
         */
        public int nextInt() throws IOException, NoSuchElementException {
            int result = 0;
            byte c = read();
            if (c == -1)
                throw new NoSuchElementException("No more testcase");
            while (c <= ' ')
                c = read();
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
