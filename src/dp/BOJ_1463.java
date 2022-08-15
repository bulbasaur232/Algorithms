package dp;

import java.util.*;
import java.io.*;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 0;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1; // i번째 숫자는 i-1번째 숫자에서 1더하면 얻을 수 있음
            if (i % 2 == 0) arr[i] = arr[i / 2] + 1 < arr[i] ? arr[i / 2] + 1 : arr[i];
            if (i % 3 == 0) arr[i] = arr[i / 3] + 1 < arr[i] ? arr[i / 3] + 1 : arr[i];
        }
        System.out.println(arr[N]);
        br.close();
    }
}
