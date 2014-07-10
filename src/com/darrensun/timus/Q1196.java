package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Timus 1196 - History Exam
 * Created by Darren on 14-7-10.
 */
public class Q1196 {

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(in.readLine());

            // Store the dates in the professor's list in a set
            Set<Integer> professorList = new HashSet<Integer>();
            for (int i = 0; i < n; i++)
                professorList.add(Integer.parseInt(in.readLine()));

            int m = Integer.parseInt(in.readLine());
            int commonDates = 0;

            // Increment the number of common dates if a date in the student's list also appear in
            // the professor's list
            for (int i = 0; i < m; i++) {
                if (professorList.contains(Integer.parseInt(in.readLine())))
                    commonDates++;
            }

            System.out.println(commonDates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
