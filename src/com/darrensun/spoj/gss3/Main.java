package com.darrensun.spoj.gss3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * SPOJ 1716 - Can you answer these queries III
 * Created by Darren on 14-8-4.
 * Segment tree is the basic idea.
 * See a similar problem SPOJ 1043 - Can you answer these queries I.
 * This piece of code would lead to TLE, but its C/C++ implementation can be accepted.
 */
public class Main {
    Parser in = new Parser(System.in);
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private int n;
    private int[] seq;      // The given sequence
    private int[] sum;      // sum[i]: sum of sequence[1...i]
    private int[] max;      // Max consecutive sum for each node
    private int[] maxPrefix;    // Max prefix sum for each node
    private int[] maxSuffix;    // Max suffix sum for each node

    void run() throws IOException {
        n = in.nextInt();
        seq = new int[n+1];
        sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            seq[i] = in.nextInt();
            sum[i] = sum[i-1] + seq[i];
        }
        max = new int[n<<2];
        maxPrefix = new int[n<<2];
        maxSuffix = new int[n<<2];

        build(1, n, 1);

        int m = in.nextInt();
        while (m-- > 0) {
            if (in.nextInt() == 1)
                out.println(query(in.nextInt(), in.nextInt(), 1, n, 1, new int[3]));
            else {
                int target = in.nextInt(), value = in.nextInt(), diff = value-seq[target];
                for (int i = target; i <= n; i++)
                    sum[i] += diff;
                update(target, value, 1, n, 1);
            }
        }
        out.flush();
    }

    /**
     * Build a segment tree with a given interval.
     * @param rangeLeft left side of the interval.
     * @param rangeRight right side of the interval.
     * @param index index of the node representing the current interval.
     */
    void build(int rangeLeft, int rangeRight, int index) {
        // A singleton interval
        if (rangeLeft == rangeRight) {
            maxPrefix[index] = maxSuffix[index] = max[index] = seq[rangeLeft];
            return;
        }

        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index<<1, rightChild = leftChild|1;

        // Recursively build the segment tree
        build(rangeLeft, middle, leftChild);
        build(middle+1, rangeRight, rightChild);

        // Update max, maxPrefix, and maxSuffix
        // max[index] = max{ max[leftChild], max[rightChild],
        // maxSurfix[leftChild]+maxPrefix[rightChild] }
        max[index] = (max[leftChild] > max[rightChild]) ? max[leftChild] : max[rightChild];
        max[index] = (max[index] > maxSuffix[leftChild]+maxPrefix[rightChild]) ? max[index] :
                maxSuffix[leftChild]+maxPrefix[rightChild];

        // maxPrefix[index] = max{ maxPrefix[leftChild],
        // sum_of_the_sequence_in_the_left_child+maxPrefix[rightChild] }
        maxPrefix[index] = (maxPrefix[leftChild] > sum[middle]-sum[rangeLeft-1]+maxPrefix[rightChild])
                ? maxPrefix[leftChild] : sum[middle]-sum[rangeLeft-1]+maxPrefix[rightChild];

        // maxSuffix[index] = max{ maxSuffix[rightChild],
        // maxSuffix[leftChild]+sum_of_the_sequence_in_the_right_child }
        maxSuffix[index] = (maxSuffix[rightChild] > maxSuffix[leftChild]+sum[rangeRight]-sum[middle])
                ? maxSuffix[rightChild] : maxSuffix[leftChild]+sum[rangeRight]-sum[middle];
    }

    /**
     * Find the max consecutive sum of the subsequence in a given interval.
     * @param queryLeft left side of the queried interval
     * @param queryRight right side of the queried interval
     * @param rangeLeft left side of the interval current node represent
     * @param rangeRight right side of the interval current node represent
     * @param index index of the node representing the current interval.
     * @param info an array of size 3 used to store additional information.
     *             info[0]: max prefix sum in the queried interval
     *             info[1]: max suffix sum in the queried interval
     *             info[2]: sum of whole sequence in the queried interval
     * @return the max consecutive sum of the subsequence in the queried interval.
     */
    int query(int queryLeft, int queryRight, int rangeLeft, int rangeRight, int index,
              int[] info) {
        // The current interval is within the queried interval
        if (queryLeft <= rangeLeft && queryRight >= rangeRight) {
            info[0] = maxPrefix[index];
            info[1] = maxSuffix[index];
            info[2] = sum[rangeRight] - sum[rangeLeft-1];
            return max[index];
        }

        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index << 1, rightChild = leftChild | 1;

        // The queried interval is in either half of the current interval
        if (queryRight <= middle)
            return query(queryLeft, queryRight, rangeLeft, middle, leftChild, info);
        if (queryLeft > middle)
            return query(queryLeft, queryRight, middle+1, rangeRight, rightChild, info);

        // The queried interval intersects with both halves
        int[] infoLeft = new int[3], infoRight = new int[3];
        int maxLeft = query(queryLeft, queryRight, rangeLeft, middle, leftChild, infoLeft);
        int maxRight = query(queryLeft, queryRight, middle+1, rangeRight, rightChild, infoRight);

        // Below is similar to what we did when building the tree
        int max = (maxLeft > maxRight) ? maxLeft : maxRight;
        max = (max > infoLeft[1]+infoRight[0]) ? max : infoLeft[1]+infoRight[0];
        info[0] = (infoLeft[0] > infoLeft[2]+infoRight[0]) ? infoLeft[0] : infoLeft[2]+infoRight[0];
        info[1] = (infoRight[1] > infoRight[2]+infoLeft[1]) ? infoRight[1] : infoRight[2]+infoLeft[1];
        info[2] = infoLeft[2] + infoRight[2];
        return max;
    }

    void update(int target, int value, int rangeLeft, int rangeRight, int index) {
        if (rangeLeft == rangeRight) {
            maxPrefix[index] = maxSuffix[index] = max[index] = value;
            return;
        }

        int middle = (rangeLeft+rangeRight) >> 1;
        int leftChild = index<<1, rightChild = leftChild|1;

        // The queried interval is in either half of the current interval
        if (target <= middle)
            update(target, value, rangeLeft, middle, leftChild);
        else
            update(target, value, middle + 1, rangeRight, rightChild);

        // The following is the same with the last part in build()
        max[index] = (max[leftChild] > max[rightChild]) ? max[leftChild] : max[rightChild];
        max[index] = (max[index] > maxSuffix[leftChild]+maxPrefix[rightChild]) ? max[index] :
                maxSuffix[leftChild]+maxPrefix[rightChild];
        maxPrefix[index] = (maxPrefix[leftChild] > sum[middle]-sum[rangeLeft-1]+maxPrefix[rightChild])
                ? maxPrefix[leftChild] : sum[middle]-sum[rangeLeft-1]+maxPrefix[rightChild];
        maxSuffix[index] = (maxSuffix[rightChild] > maxSuffix[leftChild]+sum[rangeRight]-sum[middle])
                ? maxSuffix[rightChild] : maxSuffix[leftChild]+sum[rangeRight]-sum[middle];

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
