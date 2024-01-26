import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] soldiers = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		int[] dp = new int[N];
		dp[0] = 1;
		int answer = 1;
		for (int i = 1; i < N; i++) {
			int max = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (soldiers[j] > soldiers[i] && dp[j] >= max) {
					max = dp[j] + 1;
				}
			}
			dp[i] = max;
			answer = Math.max(answer, dp[i]);
		}
		bw.write((N - answer) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
