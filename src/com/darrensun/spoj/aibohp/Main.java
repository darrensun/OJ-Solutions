package com.darrensun.spoj.aibohp;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * SPOJ 1021 - Aibohphobia
 * Created by Darren on 14-7-26.
 * Solved by DP with O(n^2) time and O(3*6100) space.
 * Note:
 *  1. Use char array instead of calling the charAt() method to retrieve each character.
 *  2. Declare the dp table as static for space reuse.
 *  3. Modulo operations are costly.
 * The problem can also be approached using the following idea: The minimum number of characters
 * inserted is equal to the difference between the length of the string and its
 * longest palindrome subsequence. The latter can be computed using the DP solution for the longest
 * common subsequence between the original string and its reverse string.
 * Proper implementation of the above idea can further make the solution with O(n^2) time and
 * O(2*6100) space.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private static short[][] dp = new short[3][6100];   // Space reuse for all test cases

    void run() throws IOException {
        int testcases = in.nextInt();
        while (testcases-- > 0) {
            String str = in.readLine();
            solve(str.toCharArray());
        }
        out.flush();
    }

    void solve(char[] str) {    // chatAt() method is slow when the string is long
        int n = str.length;

        Arrays.fill(dp[0], 0, n, (short)0);    // dp(i,i-1)
        Arrays.fill(dp[1], 0, n, (short)0);    // dp(i,i)

        // Used (costly) mod to compute row, lastRow, and lastLastRow earlier, leading to TLEs
        int row = 2, lastRow = 1, lastLastRow = 0;

        for (short d = 1; d < n; d++) {
            for (short i = 0; i < n-d; i++) {
                if (str[i] == str[i+d])   // dp(i,j) where j = i+d
                    dp[row][i] = dp[lastLastRow][i+1];
                else
                    dp[row][i] = (dp[lastRow][i] < dp[lastRow][i+1]) ?
                            (short)(dp[lastRow][i]+1) :
                            (short)(dp[lastRow][i+1]+1);
            }
            lastLastRow = lastRow;
            lastRow = row;
            row = (row == 2) ? 0 : row+1;
        }

        out.println(dp[lastRow][0]);
    }

    /**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 1 << 16;  // 2^16, a good compromise for some problems
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

        public String readLine() throws IOException {
            char c;
            while ((c = (char)(read())) == '\n') ;
            StringBuilder line = new StringBuilder();
            do {
                line.append(c);
            } while ((c = (char)(read())) != '\n');
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
