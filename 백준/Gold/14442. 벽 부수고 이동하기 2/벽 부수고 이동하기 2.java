import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	static int[][] dist;
	static char[][] map;
	static boolean[][][] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}

		dist = new int[N][M];
		map = new char[N][M];
		visit = new boolean[N][M][K+1];
		for (int r = 0; r < N; r++) {
			map[r] = br.readLine().toCharArray();
		}
		bfs();
	}

	static void bfs() {
		Deque<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0, 0));

		while (!q.isEmpty()) {
			Point curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (!isValid(nr, nc)) {
					continue;
				}
				if (map[nr][nc] == '1') {
					if (curr.crash < K && !visit[nr][nc][curr.crash]) {
						visit[nr][nc][curr.crash] = true;
						dist[nr][nc] = dist[curr.r][curr.c] + 1;
						q.offer(new Point(nr, nc, curr.crash + 1));
					}
				} else {
					if (!visit[nr][nc][curr.crash]) {
						visit[nr][nc][curr.crash] = true;
						dist[nr][nc] = dist[curr.r][curr.c] + 1;
						q.offer(new Point(nr, nc, curr.crash));
					}
				}

				if (nr == N - 1 && nc == M - 1) {
					System.out.println(dist[nr][nc] + 1);
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
	}

	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Point {
		int r, c, crash;

		public Point(final int r, final int c, final int crash) {
			this.r = r;
			this.c = c;
			this.crash = crash;
		}
	}
}
