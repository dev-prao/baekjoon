import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	static int n;
	static int[] time;
	static int[] value;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		time = new int[n];
		value = new int[n];
		dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			if(i + time[i] <= n) {
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + value[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
	}
}
