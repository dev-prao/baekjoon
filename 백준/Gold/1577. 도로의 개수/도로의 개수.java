import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] dp = new long[M + 1][N + 1];
		boolean[][][] obstacle = new boolean[M + 1][N + 1][2];

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (x < z || y < k) {
				if (x < z) //(y,x)가 (k,z)보다 위쪽
					obstacle[y][x][0] = true;
				else //(y,x)가 (k,z)보다 오른쪽
					obstacle[y][x][1] = true;
			} else {
				if (z < x) //(y,x)가 (k,z)보다 아래
					obstacle[k][z][0] = true;
				else //(y,x)가 (k,z)보다 왼쪽
					obstacle[k][z][1] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (obstacle[0][i - 1][0])
				break;
			dp[0][i] = 1;
		}
		for (int i = 1; i <= M; i++) {
			if (obstacle[i - 1][0][1])
				break;
			dp[i][0] = 1;
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				if (!obstacle[i][j - 1][0])
					dp[i][j] += dp[i][j - 1];
				if (!obstacle[i - 1][j][1])
					dp[i][j] += dp[i - 1][j];
			}
		}

		bw.write(dp[M][N] + "");

		bw.flush();
		bw.close();
		br.close();
	}
}
