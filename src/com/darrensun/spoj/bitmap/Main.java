package com.darrensun.spoj.bitmap;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * SPOJ 206 - Bitmap
 * Created by Darren on 14-7-19.
 * Conduct BFS for all white pixels simultaneously. Each pixel is enqueued exactly once.
 * Do it for each individual white pixel woule lead to TLE, since a pixel can be enqueued many
 * times.
 */
public class Main {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    void run() throws Exception {
        int testcases = Integer.parseInt(in.readLine());
        while (testcases-- > 0) {
            solve();
            in.readLine();
        }
        out.flush();
    }

    void solve() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        // minDistance[i][j]: minimum distance betwen pixel[i][j] to its nearest pixel
        int[][] minDistance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                minDistance[i][j] = Integer.MAX_VALUE;
        }

        // Row and column numbers for all white pixels
        Deque<Integer> whiteRow = new ArrayDeque<Integer>();
        Deque<Integer> whiteColumn = new ArrayDeque<Integer>();

        // Read the bitmap and save the positions of white pixels
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j)=='1') {
                    minDistance[i][j] = 0;
                    whiteRow.offer(i);
                    whiteColumn.offer(j);
                }
            }
        }

        findMinDistance(minDistance, whiteRow, whiteColumn);

        printMinDistance(minDistance);
    }

    /**
     * Find minimum distance to any white pixel for all pixels.
     * @param minDistance A matrix to be storing the minimum distances.
     * @param rowQueue Row number for each white pixel.
     * @param columnQueue Column number for each white pixel.
     */
    void findMinDistance(int[][] minDistance, Deque<Integer> rowQueue,
                         Deque<Integer> columnQueue) {
        int n = minDistance.length, m = minDistance[0].length;
        int distance = 1;   // Minimum distance to closest white pixel for neighboring pixels
        int cellsInThisLevel = rowQueue.size(), cellsInNextLevel = 0;
        while (rowQueue.peek() != null) {
            int row = rowQueue.poll(), column = columnQueue.poll();
            cellsInThisLevel--;

            // Put neighboring pixels in four directions into the queue if they have not been in
            // the queue
            if (row > 0 && minDistance[row-1][column] > distance) {     // Upper pixel
                minDistance[row-1][column] = distance;  // Avoid adding a pixel twice
                rowQueue.offer(row-1);
                columnQueue.offer(column);
                cellsInNextLevel++;
            }
            if (column > 0 && minDistance[row][column-1] > distance) {  // left pixel
                minDistance[row][column-1] = distance;
                rowQueue.offer(row);
                columnQueue.offer(column-1);
                cellsInNextLevel++;
            }
            if (row < n-1 && minDistance[row+1][column] > distance) {   // lower pixel
                minDistance[row+1][column] = distance;
                rowQueue.offer(row+1);
                columnQueue.offer(column);
                cellsInNextLevel++;
            }
            if (column < m-1 && minDistance[row][column+1] > distance) {    // right pixel
                minDistance[row][column+1] = distance;
                rowQueue.offer(row);
                columnQueue.offer(column+1);
                cellsInNextLevel++;
            }

            // All pixels distance-1 away from the closest white pixel have been visited
            if (cellsInThisLevel == 0) {
                cellsInThisLevel = cellsInNextLevel;
                cellsInNextLevel = 0;
                distance++;
            }
        }
    }

    /**
     * Print the minimum distance to any white pixel for each pixel.
     * @param minDistance A matrix storing the minimum distances.
     */
    void printMinDistance(int[][] minDistance) {
        int n = minDistance.length, m = minDistance[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(minDistance[i][j]);
                out.print(' ');
            }
            out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

}
