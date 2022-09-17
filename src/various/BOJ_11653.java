package various;

import java.util.*;
import java.io.*;

public class BOJ_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int real_number = N;
        while (true) {
            if (real_number == 1) break;
            int divider = 2;
            while (divider != N) {
                if (N % divider == 0) {
                    N = N / divider;
                    sb.append(divider);
                    sb.append("\n");
                    break;
                }
                divider++;
            }
            if (divider == N) {
                sb.append(N);
                break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
