package bfs_dfs;

import java.util.*;

public class BOJ_1697 {
    public static int N;
    public static int K;
    public static int check[] = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        Human subin = new Human(N, 0);
        Human younger = new Human(K, 0);
        Human s = hideAndSeek(subin, younger);

        System.out.println(s.movingCount);
        sc.close();
    }

    public static Human hideAndSeek(Human subin, Human younger) {
        Queue<Human> q = new LinkedList<>();
        q.offer(subin);
        check[subin.locate] = subin.movingCount;

        while (!q.isEmpty()) {
            Human s = q.poll();
            if (s.locate == younger.locate) return s;

            if (s.locate + 1 >= 0 && s.locate + 1 < 100001 && check[s.locate + 1] == 0) {
                Human h = new Human(s.locate + 1, s.movingCount + 1);
                q.offer(h);
                check[s.locate + 1] = h.movingCount;
            }

            if (s.locate - 1 >= 0 && s.locate - 1 < 100001 && check[s.locate - 1] == 0) {
                Human h = new Human(s.locate - 1, s.movingCount + 1);
                q.offer(h);
                check[s.locate - 1] = h.movingCount;
            }

            if (s.locate * 2 >= 0 && s.locate * 2 < 100001 && check[s.locate * 2] == 0) {
                Human h = new Human(s.locate * 2, s.movingCount + 1);
                q.offer(h);
                check[s.locate * 2] = h.movingCount;
            }
        }
        return null;
    }
}

class Human {
    int locate;
    int movingCount = 0;

    public Human(int locate, int movingCount) {
        this.locate = locate;
        this.movingCount = movingCount;
    }
}
