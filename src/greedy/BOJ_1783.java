package greedy;

import java.io.*;
import java.util.*;

public class BOJ_1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int visitCount = 0;

        // 세로 1칸
        if (N <= 1) {
            visitCount = 1;
        }

        // 세로 2칸
        else if (N <= 2) {
            visitCount = (M - 1) / 2 + 1;
            if (visitCount > 4)
                visitCount = 4;
        }

        // 세로 3칸 이상
        else {
            if (M < 7)
                visitCount = (M > 4) ? 4 : M;
            else
                visitCount = (M - 7) + 5;
        }

        System.out.println(visitCount);
        br.close();
    }
}