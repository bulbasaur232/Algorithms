package various;

import java.io.*;
import java.util.*;

public class BOJ_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(factorial(N));
        br.close();
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
