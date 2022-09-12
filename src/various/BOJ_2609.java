package various;

import java.io.*;
import java.util.*;

public class BOJ_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        int divider = 0;

        while (true) {
            divider = a >= b ? a : b;
            if (a <= 1 || b <= 1) break;
            while (divider > 1) {
                if (a % divider == 0 && b % divider == 0) {
                    list.add(divider);
                    a = a / divider;
                    b = b / divider;
                    break;
                }
                divider--;
            }
            if(divider == 1) break;
        }

        long cdgys = 1;
        for (int k : list) cdgys *= k;

        System.out.println(cdgys);
        System.out.println(cdgys * a * b);

        br.close();
    }
}
