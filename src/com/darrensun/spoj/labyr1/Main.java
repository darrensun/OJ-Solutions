package com.darrensun.spoj.labyr1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 38 - Labyrinth
 * Created by Darren on 14-8-5.
 * Analogous to SPOJ 1437 - Longest path in a tree.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);
    private final static String MESSAGE = "Maximum rope length is ";

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    void run() throws IOException {
        int testcases = in.nextInt();
        while (testcases-- > 0)
            solve();
        out.flush();
    }

    private int c, r;
    private static boolean[][] labyrinth = new boolean[1000][1000];
    private static boolean[][] visited = new boolean[1000][1000];
    private static short[][] height = new short[1000][1000];

    void solve() throws IOException {
        constructLabyrinth();
        int[] startBlock = findStartBlock();
        if (startBlock[0] == -1) {
            out.print(MESSAGE);
            out.print(0);
            out.println('.');
        } else {
            out.print(MESSAGE);
            out.print(dfsFind(startBlock[0], startBlock[1]));
            out.println('.');
        }
    }

    void constructLabyrinth() throws IOException {
        c = in.nextInt();
        r = in.nextInt();
        byte b;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                do {
                    b = in.read();
                } while (b != '#' && b != '.');
                labyrinth[i][j] = (b != '#');
                visited[i][j] = false;
                height[i][j] = 0;
            }
//            in.read();  // Ignore line break
        }

    }

    int[] findStartBlock() {
        int[] result = new int[2];
        result[0] = result[1] = -1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (labyrinth[i][j]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    int dfsFind(int row, int column) {
        if (!labyrinth[row][column])
            return 0;
        visited[row][column] = true;
        int maxLength = 0;
        short[] highest = new short[2];
        highest[0] = highest[1] = -1;

        int length;
        if (row+1 < r && !visited[row+1][column]) {
            length= dfsFind(row+1, column);
            maxLength = (maxLength < length) ? length : maxLength;
            updateHighest(row+1, column, highest);
        }
        if (row-1 >= 0 && !visited[row-1][column]) {
            length = dfsFind(row-1, column);
            maxLength = (maxLength < length) ? length : maxLength;
            updateHighest(row-1, column, highest);
        }
        if (column+1 < c && !visited[row][column+1]) {
            length = dfsFind(row, column+1);
            maxLength = (maxLength < length) ? length : maxLength;
            updateHighest(row, column+1, highest);
        }
        if (column-1 >= 0 && !visited[row][column-1]) {
            length = dfsFind(row, column-1);
            maxLength = (maxLength < length) ? length : maxLength;
            updateHighest(row, column-1, highest);
        }

        height[row][column] = (short)(highest[0]+1);
        if (maxLength > highest[0]+highest[1]+2)
            return maxLength;
        else
            return highest[0]+highest[1]+2;
    }

    void updateHighest(int row, int column, short[] highest) {
        if (!labyrinth[row][column])
            return;
        if (height[row][column] > highest[0]) {
            highest[1] = highest[0];
            highest[0] = height[row][column];
        } else if (height[row][column] > highest[1]) {
            highest[1] = height[row][column];
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