import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스의 수를 입력받습니다.

        for (int i = 0; i < testCase; i++) {
            int k = Integer.parseInt(br.readLine()); // 층 수 k를 입력받습니다.
            int n = Integer.parseInt(br.readLine()); // 호 수 n을 입력받습니다.

            // reader 메서드를 호출하여 결과를 출력합니다.
            System.out.println(reader(k, n));
        }

        br.close();
    }

    public static int reader(int k, int n) {
        int dp[][] = new int[k + 1][n + 1]; // 동적 프로그래밍을 위한 배열을 생성합니다.

        // 초기화: 0층의 각 호실은 호 수와 동일합니다.
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        // 동적 프로그래밍을 통해 값을 계산합니다.
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= j; l++) {
                    dp[i][j] += dp[i - 1][l]; // 현재 층의 호실 값은 이전 층의 같거나 낮은 호실 값들의 합입니다.
                }
            }
        }

        return dp[k][n]; // 결과값을 반환합니다.
    }
}
