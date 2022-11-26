package bfs_dfs;

import java.util.*;

public class BOJ_2468 {
    public static int[][] area;
    public static boolean check[][];
    public static int answer = 1;
    public static int N;
    public static int[] move_x = {1, 0, 0, -1};
    public static int[] move_y = {0, 1, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int max = 0;
        int min = 101;
        int count = 0;
        area = new int[N + 1][N + 1];
        for (int i = 1; i < area.length; i++) {
            for (int j = 1; j < area.length; j++) {
                int temp = sc.nextInt();
                if (temp < min) min = temp;
                if (temp > max) max = temp;
                area[i][j] = temp;
            }
        }
        for (int height = min; height < max; height++) {
            count = 0;
            check = new boolean[N + 1][N + 1];
            for (int i = 1; i < area.length; i++) {
                for (int j = 1; j < area.length; j++) {
                    if (area[i][j] > height && check[i][j] == false) {
                        bfs(i, j, height);
                        count++;
                    }
                }
            }
            if (count > answer) {
                answer = count;
            }
        }
        System.out.println(answer);
        sc.close();
    }

    public static void bfs(int i, int j, int height) {
        Queue<Local> q = new LinkedList<>();
        Local local = new Local(i, j);
        q.offer(local);
        check[i][j] = true;

        while (!q.isEmpty()) {
            Local l = q.poll();
            for (int k = 0; k < move_x.length; k++) {
                int x = l.x + move_x[k];
                int y = l.y + move_y[k];
                if (isSafe(x, y) == true && check[x][y] == false && area[x][y] > height) {
                    q.offer(new Local(x, y));
                    check[x][y] = true;
                }
            }
        }
    }

    public static boolean isSafe(int i, int j) {
        if (i > 0 && i <= N && j > 0 && j <= N)
            return true;
        else
            return false;
    }
}

class Local {
    int x;
    int y;

    public Local(int x, int y) {
        this.x = x;
        this.y = y;
    }
}