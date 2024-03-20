import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M, cnt;
	static char[][] map;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapInfo = br.readLine().split(" ");
		N = Integer.parseInt(mapInfo[0]);
		M = Integer.parseInt(mapInfo[1]);
		if (N == 1 && M == 1) {
			System.out.println("1");
			return;
		}
		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			String input = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = input.charAt(c);
			}
		}

		visit = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (visit[r][c] != 0) continue;
				dfs(r, c);
			}
		}

		System.out.println(cnt);
	}

	static int dfs(int r, int c) {
		if (visit[r][c] == -1) {
			cnt += 1;
			return cnt;
		}
		if (visit[r][c] > 0) {
			return visit[r][c];
		}
		visit[r][c] = -1;
		char sign = map[r][c];
		if (sign == 'D') {
			visit[r][c] = dfs(r + 1, c);
		} else if (sign == 'R') {
			visit[r][c] = dfs(r, c + 1);
		} else if (sign == 'L') {
			visit[r][c] = dfs(r, c - 1);
		} else {
			visit[r][c] = dfs(r - 1, c);
		}

		return visit[r][c];
	}
}
