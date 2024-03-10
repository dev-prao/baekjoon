import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[] curr;
	static char[] target;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		curr = br.readLine().toCharArray();
		target = br.readLine().toCharArray();
		dp = new int[curr.length + 1][target.length + 1];

		for (int i = 1; i <= curr.length; i++) {
			for (int j = 1; j <= target.length; j++) {
				if (curr[i - 1] == target[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[curr.length][target.length]);
	}
}
