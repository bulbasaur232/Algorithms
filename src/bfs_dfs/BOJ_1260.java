package bfs_dfs;


import java.io.*;
import java.util.*;

public class BOJ_1260 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        Graph graph = new Graph(N);
        for(int i = 0; i<M; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            graph.addEdge(Integer.parseInt(st1.nextToken()), Integer.parseInt(st1.nextToken()));
        }

        graph.dfs(V);
        System.out.println();
        graph.bfs(V);

        br.close();
    }

}
class Graph{
    class Node implements Comparable<Node>{
        int data;
        LinkedList<Node> adjacent;
        boolean marked_dfs;
        boolean marked_bfs;

        public Node(int data){
            this.data = data;
            adjacent = new LinkedList<>();
            marked_bfs = false;
            marked_dfs = false;
        }

        @Override
        public int compareTo(Node n){
            return this.data - n.data;
        }
    }
    Node[] nodes;

    public Graph(int size){
        nodes = new Node[size];
        for(int i = 0; i < size; i++){
            nodes[i] = new Node(i + 1);
        }
    }

    public void addEdge(int i1, int i2){
        Node n1 = nodes[i1 - 1];
        Node n2 = nodes[i2 - 1];

        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    public void bfs(int index){
        Node root = nodes[index - 1];
        Queue<Node> q = new LinkedList<>();

        q.offer(root);
        root.marked_bfs = true;

        while(!q.isEmpty()){
            Node r = q.poll();

            Collections.sort(r.adjacent);
            for(Node n : r.adjacent){
                if(n.marked_bfs == false){
                    q.offer(n);
                    n.marked_bfs = true;
                }
            }
            System.out.print(r.data + " ");
        }
    }

    public void dfs(int index){
        Node root = nodes[index - 1];
        dfsR(root);
    }

    public void dfsR(Node r){
        if(r == null)
            return;

        System.out.print(r.data + " ");
        r.marked_dfs = true;

        Collections.sort(r.adjacent);
        for(Node n : r.adjacent){
            if(n.marked_dfs == false){
                dfsR(n);
            }
        }
    }
}
