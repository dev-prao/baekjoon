import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N + 1];
		dp[0] = 0;
		dp[1] = 0;
		
		bw.write(dfs(N) + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static int dfs(int N) {
		if (dp[N] == null) {
			if (N % 6 == 0) {
				dp[N] = Math.min(dfs(N - 1), Math.min(dfs(N / 3), dfs(N / 2))) + 1;
			} else if (N % 3 == 0) {
				dp[N] = Math.min(dfs(N / 3), dfs(N - 1)) + 1;
			} else if (N % 2 == 0) {
				dp[N] = Math.min(dfs(N / 2), dfs(N - 1)) + 1;
			} else {
				dp[N] = dfs(N - 1) + 1;
			}
		}
		return dp[N];
	}
}
