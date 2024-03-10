import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] curr;
	static char[] target;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		curr = br.readLine().toCharArray();
		target = br.readLine().toCharArray();

		dp = new Integer[curr.length][target.length];

		System.out.println(LCS(curr.length - 1, target.length - 1));

	}

	static int LCS(int x, int y) {
		// 인덱스 밖 (공집합)일 경우 0 반환
		if (x == -1 || y == -1) return 0;
		// 만약 탐색하지 않은 인덱스라면?
		if (dp[x][y] == null) {
			dp[x][y] = 0;
			// curr의 x번째 문자와 target의 y번째 문자가 같은지 검사
			if (curr[x] == target[y]) dp[x][y] = LCS(x - 1, y - 1) + 1;
			// 같지 않다면 LCS(dp)[x-1][y]와 LCS(dp)[x,y-1] 중 큰 값으로 초기화
			else dp[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
		}
		return dp[x][y];
	}
}
