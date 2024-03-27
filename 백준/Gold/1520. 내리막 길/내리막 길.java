import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int M, N;
	static int[][][] dp;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		dp = new int[M][N][2]; // [0]:높이,[1]:경로 개수
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				dp[r][c][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				dp[r][c][1] = -1;
			}
		}
		
		System.out.println(dfs(0,0));
		br.close();
	}

	public static int dfs(int r, int c) {
		//최종 경로에 도달한 경우
		if (r == M - 1&& c == N - 1) return 1;
		//이미 경로가 구해진 경우
		if (dp[r][c][1] != -1) return dp[r][c][1];
		//경로가 구해지지 않은 경우 0으로 초기화
		dp[r][c][1] = 0;
		//사방탐색 실시
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isInValid(nr, nc)) continue;
			//(r,c)의 높이 > (nr,nc)의 높이이면 (nr,nc)부터 (N-1,M-1)까지의 경로의 개수를 더함
			if (dp[r][c][0] > dp[nr][nc][0]) dp[r][c][1] += dfs(nr, nc);
		}
		return dp[r][c][1];
	}
	
	static boolean isInValid(int r, int c) {
		return r < 0 || c < 0 || r >= M || c >= N;
	}
}