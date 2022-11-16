package bfs_dfs;

import java.util.*;

public class BOJ_2178 {

    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N][M];
        visited = new boolean[N][M];

        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0, 0);
        sc.close();
    }

    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();

        q.offer(new Point(x, y, 1));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x + 1 < N && maze[p.x + 1][p.y] == 1 && visited[p.x + 1][p.y] == false) {
                q.offer(new Point(p.x + 1, p.y, p.count + 1));
                visited[p.x + 1][p.y] = true;
            }
            if (p.y + 1 < M && maze[p.x][p.y + 1] == 1 && visited[p.x][p.y + 1] == false) {
                q.offer(new Point(p.x, p.y + 1, p.count + 1));
                visited[p.x][p.y + 1] = true;
            }
            if (p.x - 1 >= 0 && maze[p.x - 1][p.y] == 1 && visited[p.x - 1][p.y] == false) {
                q.offer(new Point(p.x - 1, p.y, p.count + 1));
                visited[p.x - 1][p.y] = true;
            }
            if (p.y - 1 >= 0 && maze[p.x][p.y - 1] == 1 && visited[p.x][p.y - 1] == false) {
                q.offer(new Point(p.x, p.y - 1, p.count + 1));
                visited[p.x][p.y - 1] = true;
            }
            if (p.x == N - 1 && p.y == M - 1) {
                System.out.println(p.count);
                break;
            }
        }
    }
}

class Point {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
