import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 표의 크기
        int m = Integer.parseInt(st.nextToken()); // 질의 갯수

        int A[][] = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int D[][] = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }
        for (int i = 1 ; i <= m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1]);
        }

    }
}