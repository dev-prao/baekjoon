import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		padovan();
		
		for(int test = 0; test < T; test++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void padovan() {
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i = 4; i < 101; i++) {
			dp[i] = dp[i-2] + dp[i-3];
		}
	}
}
