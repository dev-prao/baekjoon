import java.io.*;
import java.math.BigInteger;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 3 ; i++) {
            BigInteger sum = new BigInteger("0");
            int n = Integer.parseInt(br.readLine());

            for (int j = 0 ; j < n ; j++) {
                BigInteger n2 = new BigInteger(br.readLine());
                sum = sum.add(n2);
            }

            if(sum.compareTo(BigInteger.ZERO) == -1) {
                System.out.println("-");
            } else if(sum.compareTo(BigInteger.ZERO) == 1) {
                System.out.println("+");
            } else {
                System.out.println(0);
            }
        }
    }
}