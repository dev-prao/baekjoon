import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 첫째줄 - 표의 크기 n, 합을 구해야 하는 횟수 m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 둘째줄부터 n개의 줄
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1 ; i <= n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간 합 구하기
        int arrSum[][] = new int[n + 1][n + 1];
        arrSum[1][1] = arr[1][1];
        for (int i = 2 ; i <= n ; i++) {
            arrSum[1][i] = arrSum[1][i - 1] + arr[1][i];
        }
        for (int i = 2 ; i <= n ; i++) {
            arrSum[i][1] = arrSum[i-1][1] + arr[i][1];
        }
        for (int i = 2 ; i <= n ; i++) {
            for (int j = 2 ; j <= n ; j++) {
                arrSum[i][j] = arrSum[i-1][j] + arrSum[i][j-1] + arr[i][j] - arrSum[i-1][j-1];
            }
        }

        // m번 만큼 질의에 대한 값 출력
        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(arrSum[x2][y2] - arrSum[x2][y1 - 1] - arrSum[x1 - 1][y2] + arrSum[x1 - 1][y1 - 1]);
        }
    }
}