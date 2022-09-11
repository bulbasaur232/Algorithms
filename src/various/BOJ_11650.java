package various;

import java.io.*;
import java.util.*;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<NumPair> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new NumPair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        Iterator<NumPair> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        br.close();
    }
}

class NumPair implements Comparable<NumPair> {
    int x;
    int y;

    public NumPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(NumPair o) {
        if (this.x != o.x) return this.x - o.x;
        else return this.y - o.y;
    }

    public String toString() {
        return "" + x + " " + y;
    }
}
