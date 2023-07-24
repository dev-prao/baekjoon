import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int num = L * P;
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < 5 ; i++) {
            System.out.print(Integer.parseInt(st.nextToken()) - num + " ");
        }
        br.close();
    }
}