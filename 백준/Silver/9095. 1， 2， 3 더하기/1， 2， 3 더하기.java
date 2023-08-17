import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[11]; // 인덱스는 0부터 시작이라... 차라리 공간을 하나 더 두기
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int j=4; j<=10; j++) {
			dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; // 4 = 1, 2, 3 // 점화식
		}
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}