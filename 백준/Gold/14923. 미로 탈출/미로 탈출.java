import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] start, end;
	static int[][] map;
	static boolean[][][] isVisited;

	static int[][] deltas = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		isVisited = new boolean[2][n][m];

		st = new StringTokenizer(br.readLine());
		start = new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 };
		st = new StringTokenizer(br.readLine());
		end = new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 };

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}

	static int bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { start[0], start[1], 1, 0 }); // r,c,남은 지팡이 횟수, 거리
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int crash = cur[2];
			int dist = cur[3];

			for (int[] delta : deltas) {
				int nr = r + delta[0];
				int nc = c + delta[1];

				if (nr == end[0] && nc == end[1])
					return dist + 1;

				if (isInValid(nr, nc) || isVisited[crash][nr][nc])
					continue;

				if (map[nr][nc] == 1 && crash > 0) {
					isVisited[crash - 1][nr][nc] = true;
					q.offer(new int[] { nr, nc, crash - 1, dist + 1 });
					continue;
				}

				if (map[nr][nc] == 0) {
					isVisited[crash][nr][nc] = true;
					q.offer(new int[] { nr, nc, crash, dist + 1 });
				}
			}

		}
		return -1;
	}

	static boolean isInValid(int r, int c) {
		return r < 0 || c < 0 || r >= n || c >= m;
	}
}