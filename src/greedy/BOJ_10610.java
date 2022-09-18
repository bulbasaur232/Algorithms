package greedy;

import java.io.*;
import java.util.*;

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        String[] arr = new String[st.length()];
        for (int i = 0; i < st.length(); i++) {
            arr[i] = String.valueOf(st.charAt(i));
        }
        LinkedList<String> list = new LinkedList<>((Arrays.asList(arr)));
        int sumOfDigits = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sumOfDigits += Integer.parseInt(it.next());
        }

        StringBuilder sb = new StringBuilder();
        if (list.contains("0") && sumOfDigits % 3 == 0) {
            Collections.sort(list, Comparator.reverseOrder());
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
            }
        } else
            sb.append("-1");
        System.out.println(sb);
        br.close();
    }
}
