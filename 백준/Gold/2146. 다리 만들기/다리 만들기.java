import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static class Pair {
		int r;
		int c;
		int w;

		public Pair(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static final int[] dr = {1, -1, 0, 0};
	static final int[] dc = {0, 0, 1, -1};
	static int N, ans;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int group = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					bfs(i, j, group++);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0) {
					ans = Math.min(ans, calDist(i, j, arr[i][j]));
				}
			}
		}
		System.out.println(ans);
	}

	static void bfs(int r, int c, int group) {
		arr[r][c] = group;
		Deque<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(r, c));

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N) {
					if (arr[nr][nc] == 1) {
						arr[nr][nc] = group;
						q.add(new Pair(nr, nc));
					}
				}
			}
		}
	}

	static int calDist(int r, int c, int group) {
		Deque<Pair> q = new ArrayDeque<>();
		q.offer(new Pair(r, c, 0));

		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N) {
					if (arr[nr][nc] != group && arr[nr][nc] != 0) {
						return p.w;
					}
					if (arr[nr][nc] == 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Pair(nr, nc, p.w + 1));
					}
				}
			}
		}
		return Integer.MAX_VALUE;
	}
}
