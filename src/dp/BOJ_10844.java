package dp;

import java.io.*;
import java.math.BigInteger;

public class BOJ_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[101][10];
        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0)
                    dp[i][0] = dp[i - 1][1] % 1000000000;
                else if (j == 9)
                    dp[i][9] = dp[i - 1][8] % 1000000000;
                else
                    dp[i][j] = (dp[i - 1][j + 1] % 1000000000) + (dp[i - 1][j - 1] % 1000000000);
            }
        }

        BigInteger totalNum = new BigInteger("0");
        for (int i : dp[N]) {
          totalNum = totalNum.add(new BigInteger(String.valueOf(i % 1000000000)));
        }

        System.out.println(totalNum.remainder(new BigInteger("1000000000")));
        br.close();
    }
}
