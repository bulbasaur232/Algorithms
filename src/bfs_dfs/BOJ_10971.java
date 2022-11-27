package bfs_dfs;

import java.util.*;

public class BOJ_10971 {
    static int N;
    static int[][] cities;
    static int minCost = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cities = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cities[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 0);
            visited[i] = false;
        }
        System.out.println(minCost);
        sc.close();
    }

    public static void dfs(int start, int now, int cost, int count) {
        if (count == N - 1) {
            if (cities[now][start] != 0) {
                cost += cities[now][start];
                if (cost < minCost) minCost = cost;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && cities[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, cost + cities[now][i], count + 1);
                visited[i] = false;
            }
        }
    }
}

