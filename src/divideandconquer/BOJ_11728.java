package divideandconquer;

import java.util.*;
import java.io.*;

public class BOJ_11728 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }
        int A = 0;
        int B = 0;
        StringBuilder sb = new StringBuilder();
        while (A != N && B != M) {
            if (arr1[A] < arr2[B]) {
                sb.append(arr1[A++] + " ");
            } else {
                sb.append(arr2[B++] + " ");
            }
        }

        while (A < N) {
            sb.append(arr1[A++] + " ");
        }
        while (B < M) {
            sb.append(arr2[B++] + " ");
        }
        System.out.println(sb);
    }
}
