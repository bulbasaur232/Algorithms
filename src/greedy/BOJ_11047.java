package greedy;

import java.io.*;
import java.util.*;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        int typeNum = Integer.parseInt(st[0]); // 동전 종류의 수
        int value = Integer.parseInt(st[1]); // 계산해야할 총 가치
        int[] types = new int[typeNum]; // 각 동전의 가치
        int[] count = new int[typeNum]; // 각 동전이 몇 개씩 필요한지

        // 각 동전의 가치를 입력받는다.
        for (int i = 0; i < typeNum; i++) {
            types[i] = sc.nextInt();
        }

        // 동전의 수를 최소화하려면 가치가 큰 동전부터 채워넣는다.
        for (int i = types.length - 1; i >= 0; i--) {
            if (value == 0) break;

            // value가 동전의 값보다 클 경우 나눗셈의 몫으로 동전이 몇개 필요한지 계산
            if (value / types[i] >= 1) {
                count[i] = value / types[i];
                value = value % types[i];
            }
        }

        int numOfCoin = 0;
        for (int coins : count) {
            numOfCoin += coins;
        }
        System.out.println(numOfCoin);
        sc.close();
    }
}
