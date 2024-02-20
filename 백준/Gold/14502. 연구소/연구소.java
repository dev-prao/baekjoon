import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static int n, m;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] map;
	public static int[][] virus;
	public static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0);

		System.out.println(max);
	}

	private static void dfs(int count) {
		if (count == 3) {
			bfs();
			return;
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] == 0) {
					map[r][c] = 1;
					dfs(count + 1);
					map[r][c] = 0;
				}
			}
		}
	}

	private static void bfs() {
		Deque<int[]> queue = new ArrayDeque<>();
		virus = new int[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				virus[r][c] = map[r][c];
				if (virus[r][c] == 2) {
					queue.offer(new int[] { r, c });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m || virus[nr][nc] != 0) {
					continue;
				}
				virus[nr][nc] = 2;
				queue.add(new int[] { nr, nc });
			}
		}
		
		int count = 0;
		for(int r = 0; r < n; r++) {
			for(int c = 0; c < m; c++) {
				if(virus[r][c] == 0) {
					count++;
				}
			}
		}
		
		max = Math.max(max, count);
	}
}
