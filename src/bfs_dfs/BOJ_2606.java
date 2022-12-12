package bfs_dfs;

import java.util.*;
import java.io.*;

public class BOJ_2606 {
    static ArrayList<Node> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < comNumber; i++) {
            list.add(new Node());
        }

        int edgeNumber = Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            addEdge(list.get(Integer.parseInt(st.nextToken()) - 1), list.get(Integer.parseInt(st.nextToken()) - 1));
        }

        bfs(list.get(0));
        System.out.println(count);

        br.close();
    }

    public static void addEdge(Node n1, Node n2) {
        n1.adjacent.add(n2);
        n2.adjacent.add(n1);
    }

    public static void bfs(Node first) {
        Queue<Node> q = new LinkedList<>();
        q.offer(first);
        first.visit = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (Node p : n.adjacent) {
                if (p.visit == false) {
                    q.offer(p);
                    p.visit = true;
                    count++;
                }
            }

        }
    }
}


class Node {
    public ArrayList<Node> adjacent;
    public boolean visit;

    public Node() {
        this.adjacent = new ArrayList<Node>();
        this.visit = false;
    }
}