package various;

import java.io.*;
import java.util.*;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<NumPair2> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new NumPair2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        Iterator<NumPair2> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        br.close();
    }
}

class NumPair2 implements Comparable<NumPair2> {
    int x;
    int y;

    public NumPair2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(NumPair2 o) {
        if (this.y != o.y) return this.y - o.y;
        else return this.x - o.x;
    }

    public String toString() {
        return "" + x + " " + y;
    }
}


