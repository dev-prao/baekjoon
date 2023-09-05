import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArr = new int[m];
        for (int i = 0 ; i < m ; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0 ; i < m ; i++) {
            boolean count = false;
            for (int j = 0 ; j < n ; j++) {
                if(mArr[i] == nArr[j]) {
                    count = true;
                    break;
                }
            }
            if (count) sb.append(1 + "\n");
            else sb.append(0 + "\n");
        }
        System.out.println(sb);
    }
}

