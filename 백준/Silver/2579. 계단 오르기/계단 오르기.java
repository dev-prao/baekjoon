import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int N;
	static int[] arr;
	static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new Integer[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = arr[0];
		dp[1] = arr[1];

		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		bw.write(String.valueOf(getScore(N)));
		bw.close();
		br.close();
	}

	private static int getScore(int n) {
		if (dp[n] == null) {
			dp[n] = Math.max(getScore(n - 2), getScore(n - 3) + arr[n - 1]) + arr[n];
		}
		return dp[n];
	}
}
