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
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] gym = new long[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				gym[i][j] = Long.parseLong(st.nextToken());
			}
		}
		int H = Integer.parseInt(br.readLine());

		for (int r = N - 1; r >= 0; r--) {
			for (int c = M - 1; c >= 0; c--) {
				if (r == N - 1 && c == M - 1)
					continue;
				if (r == N - 1) {
					gym[r][c] += gym[r][c + 1];
					continue;
				}
				if (c == M - 1) {
					gym[r][c] += gym[r + 1][c];
					continue;
				}
				gym[r][c] += Math.min(gym[r + 1][c], gym[r][c + 1]);
			}
		}
		if (gym[0][0] > H) {
			sb.append("NO");
		} else {
			sb.append("YES\n").append(gym[0][0]);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

