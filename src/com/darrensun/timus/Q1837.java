package com.darrensun.timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/**
 * Timus 1837 - Isenbaev's Number
 * Created by Darren on 14-7-10.
 * Isenbaev number is found by BFS starting at Isenbaev.
 */
public class Q1837 {

    class Contestant implements Iterable {
        private boolean visited = false;    // Used for BFS
        private int isenbaevNumber = -1;    // Undefined
        private Set<String> teammates = new HashSet<String>();

        public void setIsenbaevNumber(int number) {
            isenbaevNumber = number;
        }

        public int getIsenbaevNumber() {
            return isenbaevNumber;
        }

        public void setVisited() {
            visited = true;
        }

        public boolean getVisited() {
            return visited;
        }

        public void addTeammate(String teammate) {
            teammates.add(teammate);
        }

        public Iterator<String> iterator() {
            return teammates.iterator();
        }
    }

    public final static String ISENBAEV = "Isenbaev";
    Map<String, Contestant> contestants;

    public Q1837() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int teams = Integer.parseInt(in.readLine());
        contestants = new TreeMap<String, Contestant>(); // Used for convenience of ordered output
        for (int i = 0; i < teams; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            String contestant1 = tokenizer.nextToken();
            String contestant2 = tokenizer.nextToken();
            String contestant3 = tokenizer.nextToken();

            // Add new contestant if any
            if (!contestants.containsKey(contestant1))
                contestants.put(contestant1, new Contestant());
            if (!contestants.containsKey(contestant2))
                contestants.put(contestant2, new Contestant());
            if (!contestants.containsKey(contestant3))
                contestants.put(contestant3, new Contestant());

            // Construct teammate relationships for each contestant in the team
            contestants.get(contestant1).addTeammate(contestant2);
            contestants.get(contestant1).addTeammate(contestant3);
            contestants.get(contestant2).addTeammate(contestant3);
            contestants.get(contestant2).addTeammate(contestant1);
            contestants.get(contestant3).addTeammate(contestant1);
            contestants.get(contestant3).addTeammate(contestant2);
        }
    }

    public static void main(String[] args) {
        try {
            Q1837 q1837 = new Q1837();
            q1837.findIsenbaevNumber();
            q1837.printResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find Isenbaev number for each contestant by BFS.
     */
    public void findIsenbaevNumber() {
        // Do not leave out the possibility that Isenbaev is not included in the input
        if (!contestants.containsKey(ISENBAEV))
            return;

        // Put Isenbaev into the queue first
        Deque<String> queue = new ArrayDeque<String>();
        queue.offer(ISENBAEV);
        contestants.get(ISENBAEV).setVisited();

        // Indicate when contestants with the same Isenbaev number have been visited already
        int numOfCurrentLevel = 1, numOfNextLevel = 0;

        int isenbaevNumber = 0;
        while (queue.peek() != null) {
            // Assign Isenbaev number to the first contestant in the queue
            String name = queue.poll();
            numOfCurrentLevel--;
            Contestant current = contestants.get(name);
            current.setIsenbaevNumber(isenbaevNumber);

            // Add its unvisited teammates into the queue
            for (Iterator<String> iterator = current.iterator(); iterator.hasNext(); ) {
                String teammate = iterator.next();
                if (!contestants.get(teammate).getVisited()) {
                    queue.offer(teammate);
                    contestants.get(teammate).setVisited();
                    numOfNextLevel++;
                }
            }

            // The contestants with the same current Isenbaev number have all been visited
            if (numOfCurrentLevel == 0) {
                numOfCurrentLevel = numOfNextLevel;
                numOfNextLevel = 0;
                isenbaevNumber++;
            }
        }
    }

    /**
     * Print the name of each contestant and its Isenbaev number, in the lexicographical order of
     * the names.
     */
    public void printResult() {
        PrintWriter out = new PrintWriter(System.out);
        for (Map.Entry<String, Contestant> entry : contestants.entrySet()) {
            out.print(entry.getKey());
            out.print(' ');
            int isenbaevNumber = entry.getValue().getIsenbaevNumber();
            out.println(isenbaevNumber >= 0 ? isenbaevNumber : "undefined");
        }
        out.flush();
    }
}
