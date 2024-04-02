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

		isVisited = new boolean[n][m][k + 1];
		if (n == 1 && m == 1) {
			out.println(1);
		} else {
			out.println(bfs());
		}
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
				int dr = r + delta[d][0];
				int dc = c + delta[d][1];
				if (!isValid(dr, dc))
					continue;
				if (dr == n - 1 && dc == m - 1) {
					return dist + 1;
				}
				if (isVisited[dr][dc][crashCnt])
					continue;
				if (map[dr][dc] == '1' && crashCnt > 0) {
					if (dist % 2 == 1) { // 낮
						isVisited[dr][dc][crashCnt - 1] = true;
						isVisited[dr][dc][crashCnt] = true;
						q.add(new int[] { dr, dc, crashCnt - 1, dist + 1 });
					}
					if (dist % 2 == 0) { // 밤
						q.add(new int[] { r, c, crashCnt, dist + 1 });
					}
				} else if (map[dr][dc] == '0') {
					isVisited[dr][dc][crashCnt] = true;
					q.add(new int[] { dr, dc, crashCnt, dist + 1 });
				}
			}
		}
		return -1;
	}

	private static boolean isValid(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}
