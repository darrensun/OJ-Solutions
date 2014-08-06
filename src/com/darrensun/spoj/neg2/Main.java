package com.darrensun.spoj.neg2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * SPOJ 739 - The Moronic Cowmpouter
 * Created by Darren on 14-7-29.
 * Increment residual n by one whenever a mismatch of signs happen.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out, true);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int n = in.nextInt();
        if (n == 0)
            out.println(0);
        else {
            List<Integer> digits = new ArrayList<Integer>();
            boolean flag = false;

            if (n < 0) {
                n = -n;
                flag = true;
            }

            while (n > 0) {
                digits.add(n & 1);
                if (flag) {  // Mismatch of signs
                    if (n == 1) {   // Already the last step
                        digits.add(1);
                        break;
                    }
                    if ((n&1) == 1) // Add one to one higher position to correct the mismatch
                        n++;
                }
                n >>= 1;
                flag = !flag;
            }
            print(digits);
        }
    }

    void print(List<Integer> list) {
        for (int i = list.size()-1; i >= 0; i--)
            out.print(list.get(i));
        out.println();
    }

    /**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 20;
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
