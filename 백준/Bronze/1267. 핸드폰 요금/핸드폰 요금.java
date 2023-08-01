import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = 0;
        int M = 0;
        for (int i = 0 ; i < n ; i++) {
            int callTime = Integer.parseInt(st.nextToken());
            Y += ((callTime / 30) + 1) * 10;
            M += ((callTime / 60) + 1) * 15;
        }

        if (Y > M) {
            System.out.println("M " + M);
        } else if (Y == M) {
            System.out.println("Y M " + M);
        } else {
            System.out.println("Y " + Y);
        }
        br.close();
    }
}