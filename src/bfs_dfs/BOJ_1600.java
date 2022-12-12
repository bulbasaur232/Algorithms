package bfs_dfs;

import java.util.*;
import java.io.*;


public class BOJ_1600 {
    static int K;
    static int N;
    static int M;
    static int[][] map;
    static boolean[][][] check;
    static int[] monkeyMove_X = {1, 0, -1, 0};
    static int[] monkeyMove_Y = {0, 1, 0, -1};
    static int[] horseMove_X = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] horseMove_Y = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        check = new boolean[M + 1][N + 1][K + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        br.close();
    }

    public static void bfs() {
        Queue<Grid> q = new LinkedList<Grid>();
        Grid grid = new Grid(1, 1, 0, K);
        q.offer(grid);
        check[1][1][K] = true;

        while (!q.isEmpty()) {
            Grid g = q.poll();

            if (g.x == M && g.y == N) {
                System.out.println(g.count);
                return;
            }

            if (g.energy > 0) {
                for (int i = 0; i < horseMove_X.length; i++) {
                    int newX = g.x + horseMove_X[i];
                    int newY = g.y + horseMove_Y[i];
                    if (isSafe(newX, newY)) {
                        if (!check[newX][newY][g.energy - 1]) {
                            q.offer(new Grid(newX, newY, g.count + 1, g.energy - 1));
                            check[newX][newY][g.energy - 1] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < monkeyMove_X.length; i++) {
                int newX = g.x + monkeyMove_X[i];
                int newY = g.y + monkeyMove_Y[i];
                if (isSafe(newX, newY)) {
                    if (!check[newX][newY][g.energy]) {
                        q.offer(new Grid(newX, newY, g.count + 1, g.energy));
                        check[newX][newY][g.energy] = true;
                    }
                }
            }
        }
        System.out.println(-1);

    }

    public static boolean isSafe(int x, int y) {
        if (x <= M && x > 0 && y <= N && y > 0 && map[x][y] != 1)
            return true;
        return false;
    }
}

class Grid {
    int x;
    int y;
    int count;
    int energy;

    public Grid(int x, int y, int count, int energy) {
        this.x = x;
        this.y = y;
        this.energy = energy;
        this.count = count;
    }
}
