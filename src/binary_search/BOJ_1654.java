package binary_search;

import java.util.*;
import java.io.*;

public class BOJ_1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        int lines = Integer.parseInt(str[0]); // 갖고 있는 랜선의 수 K
        int toMakeLines = Integer.parseInt(str[1]); // 만들어야 할 랜선의 수 N
        ArrayList<Integer> lengthOfLines = new ArrayList<>(); // K개 랜선들의 길이
        for (int i = 0; i < lines; i++) {
            lengthOfLines.add(sc.nextInt());
        }
        int canMakeLines = 0; // 만들 수 있는 랜선의 수
        long start = 1;
        long end = Collections.max(lengthOfLines);
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            canMakeLines = 0;
            for (int i = 0; i < lines; i++) {
                canMakeLines += lengthOfLines.get(i) / mid;
            }
            // 만들 수 있는 랜선 갯수가 만들어야 할 수보다 작은 경우 <- 너무 적게 만듦
            if (canMakeLines < toMakeLines) end = mid - 1;
            // 만들 수 있는 랜선 갯수가 만들어야 할 수보다 큰 경우 <- 너무 많이 만듦
            // N==K에 도달해도 이를 만족하는 더 큰 길이가 있을수 있으므로 계속 탐색
            else start = mid + 1;
        }
        System.out.println(end);
    }
}
