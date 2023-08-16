import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n + 1];
        a[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = 1;
        while (st.hasMoreTokens()) {
            a[x] = Integer.parseInt(st.nextToken());
            x++;
        }

        int[] d = new int[n + 1];

        for (int i = 1 ; i < n + 1 ; i++) {
            d[i] = -1;
        }

        for (int i = 1 ; i < n + 1 ; i++) {
            for (int j = 1 ; j < i + 1 ; j++) {
                if (d[i] == -1 || d[i] > d[i - j] + a[j]) {
                    d[i] = d[i - j] + a[j];
                }
            }
        }
        System.out.println(d[n]);
    }
}