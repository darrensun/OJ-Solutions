package com.darrensun.spoj.pt07z;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * SPOJ 1437 - Longest path in a tree
 * Created by Darren on 14-7-20.
 * Do one BFS/DFS to find the farthest vertex from a randomly selected one. This vertex is one
 * end of the longest path. Then do another BFS/DFS from this vertex. The distance between it and
 * its farthest vertex is the length of the longest path.
 * The problem can also be solved using one DFS. See http://cs.stackexchange
 * .com/questions/11263/longest-path-in-an-undirected-tree-with-only-one-traversal
 * for more information.
 */
public class Main {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    class Node {
        int id;
        int height;
        Set<Integer> edges;

        public Node(int id) {
            this.id = id;
            height = -1;
            edges = new HashSet<Integer>();
        }

        public int getDegree() {
            return edges.size();
        }

        public void addEdge(int v) {
            edges.add(v);
        }

        public void removeEdge(int v) {
            edges.remove(v);
        }

        public Iterator<Integer> edgeIterator() {
            return edges.iterator();
        }
    }

    void run() throws Exception {
        int n = Integer.parseInt(in.readLine());
        List<Node> nodes = new ArrayList<Node>(n+1);
        nodes.add(null);
        for (int i = 1; i <= n; i++)
            nodes.add(new Node(i));

        for (int i = 1; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            nodes.get(u).addEdge(v);
            nodes.get(v).addEdge(u);
        }

        out.println(dfsFind(nodes, 1));
        out.flush();
    }

    int dfsFind(List<Node> nodes, int id) {
        Node node = nodes.get(id);
        // Null node
        if (node == null)
            return -1;

        // Leaf node
        if (node.edges.isEmpty()) {
            node.height = 0;
            return 0;
        }

        int maxLength = 0;  // Length of the longest path among all subtrees
        // Highest and second highest height among subtrees
        // They are by default -1 since the height for a null node is -1
        int highest = -1, secondHighest = -1;

        // Recursive DFS
        int i = 0;
        for (Iterator<Integer> iterator = node.edgeIterator(); iterator.hasNext(); i++) {
            int v = iterator.next();
            iterator.remove();
            nodes.get(v).removeEdge(node.id);
            // Recursive call to find the longest path for the subtree rooted at v
            int length = dfsFind(nodes, v);
            // Update maxLength
            maxLength = (maxLength < length) ? length : maxLength;

            // Update highest and second highest height among all subtrees
            int height = nodes.get(v).height;
            if (height > highest) {
                secondHighest = highest;
                highest = height;
            } else if (height > secondHighest) {
                secondHighest = height;
            }
        }

        node.height = highest + 1;  // By definition of height

        // The longest path for the tree rooted at node is either the longest path in a subtree,
        // or a path connecting the highest subtree and the second highest subtree via the root
        // node
        if (maxLength > highest+secondHighest+2)
            return maxLength;
        else
            return highest+secondHighest+2;
    }

//    void run() throws Exception {
//        int n = Integer.parseInt(in.readLine());
//        List<Set<Integer>> edges = new ArrayList<Set<Integer>>(n+1);
//        edges.add(null);
//        for (int i = 0; i < n; i++)
//            edges.add(new HashSet<Integer>());
//
//        for (int i = 1; i < n; i++) {
//            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
//            int u = Integer.parseInt(tokenizer.nextToken());
//            int v = Integer.parseInt(tokenizer.nextToken());
//            edges.get(u).add(v);
//            edges.get(v).add(u);
//        }
//
//        int source = bfsSearch(edges);
//        out.println(lengthOfLongestPath(edges, source));
//        out.flush();
//    }
//
//    /**
//     * Find by BFS the vertex that is farthest from vertex 1 by BFS.
//     * @param edges Adjacency list presentation of the tree.
//     * @return The vertex that is farthest from vertex 1.
//     */
//    int bfsSearch(List<Set<Integer>> edges) {
//        boolean[] visited = new boolean[edges.size()];
//        Deque<Integer> queue = new ArrayDeque<Integer>();
//        visited[1] = true;
//        queue.offer(1);
//        int lastVertex = 0;
//        while (queue.peek() != null) {
//            int u = queue.poll();
//            lastVertex = u;
//            for (int v : edges.get(u)) {
//                if (!visited[v]) {
//                    visited[v] = true;
//                    queue.offer(v);
//                }
//            }
//        }
//        return lastVertex;
//    }
//
//    /**
//     * Find by BFS the length of the longest path starting with a given vertex.
//     * @param edges Adjacency list presentation of the tree.
//     * @param source The given vertex.
//     * @return The length of the longest path starting with the given vertex.
//     */
//    int lengthOfLongestPath(List<Set<Integer>> edges, int source) {
//        Deque<Integer> queue = new ArrayDeque<Integer>();
//        queue.offer(source);
//        int length = -1;
//        int verticesInThisLevel = 1, verticesInNextLevel = 0;
//        while (queue.peek() != null) {
//            int u = queue.poll();
//            verticesInThisLevel--;
//            for (Iterator<Integer> iterator = edges.get(u).iterator(); iterator.hasNext(); ) {
//                int v = iterator.next();
//                queue.offer(v);
//                verticesInNextLevel++;
//                iterator.remove();
//                edges.get(v).remove(u);
//            }
//            if (verticesInThisLevel == 0) {
//                verticesInThisLevel = verticesInNextLevel;
//                verticesInNextLevel = 0;
//                length++;
//            }
//        }
//        return length;
//    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
