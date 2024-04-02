import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k;
	static StringBuilder sb;
	static char[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		isVisited = new boolean[k + 1][n][m];
		if (n == 1 && m == 1) {
			out.println(1);
			return;
		}
		out.println(bfs());
	}

	static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, k, 1 });

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int r = poll[0];
			int c = poll[1];
			int crashCnt = poll[2];
			int dist = poll[3];

			for (int d = 0; d < 4; d++) {
				int nr = r + delta[d][0];
				int nc = c + delta[d][1];
				if (!isValid(nr, nc))
					continue;
				
				if (nr == n - 1 && nc == m - 1) return dist + 1;
				
				if (isVisited[crashCnt][nr][nc]) continue;

				if (map[nr][nc] == '1' && crashCnt > 0) {
					if (dist % 2 == 1) { // 낮
						isVisited[crashCnt - 1][nr][nc] = true; //방문 처리
						isVisited[crashCnt][nr][nc] = true; //??
						q.add(new int[] { nr, nc, crashCnt - 1, dist + 1 });
					}
					if (dist % 2 == 0) { // 밤
						q.add(new int[] { r, c, crashCnt, dist + 1 });
					}
				} else if (map[nr][nc] == '0') {
					isVisited[crashCnt][nr][nc] = true;
					q.add(new int[] { nr, nc, crashCnt, dist + 1 });
				}
			}
		}
		return -1;
	}

	static boolean isValid(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}
