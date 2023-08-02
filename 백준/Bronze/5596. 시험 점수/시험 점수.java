import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = 0;
        int T = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 4 ; i++) {
            S += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 4 ; i++) {
            T += Integer.parseInt(st.nextToken());
        }

        System.out.println((T > S) ? T : S);

        br.close();
    }
}