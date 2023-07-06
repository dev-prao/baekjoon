import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        for (int i = 0 ; i < n - 1 ; i++) {
            for (int j = i + 1 ; j < n ; j++) {
                if (A[i] + A[j] == m) {
                    count++;
                }
            }
        }
        System.out.println(count);


    }
}