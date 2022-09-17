package various;

import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class BOJ_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger factorialVal = factorial(n);
        String stringVal = factorialVal.toString();
        int count = 0;
        for (int i = stringVal.length() - 1; i >= 0; i--) {
            if(stringVal.charAt(i) != '0') break;
            if(stringVal.charAt(i) == '0') count++;
        }
        System.out.println(count);
        br.close();
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(new BigInteger("0"))) return new BigInteger("1");
        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }
}
