import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r, c, dist, crash, daytime;

		public Node(int r, int c, int dist, int crash, int daytime) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.crash = crash;
			this.daytime = daytime;
		}
	}

	static int N, M, K;
	static int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] isWall;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		isWall = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				isWall[i][j] = (input.charAt(j) == '0' ? true : false);
			}
		}

		bw.write(String.valueOf(getMinDist()));
		br.close();
		bw.close();
	}

	private static int getMinDist() {
		boolean[][][][] isVisited = new boolean[N][M][K + 1][2];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 1, 0, 0));
		isVisited[0][0][0][0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.r == N - 1 && cur.c == M - 1) return cur.dist;

			for (int[] dir : dirs) {
				int nr = cur.r + dir[0];
				int nc = cur.c + dir[1];

				if (0 > nr || nr >= N || 0 > nc || nc >= M) continue;

				if (isWall[nr][nc] && cur.daytime == 0 && !isVisited[nr][nc][cur.crash][cur.daytime + 1]) {
					q.add(new Node(nr, nc, cur.dist + 1, cur.crash, cur.daytime + 1));
					isVisited[nr][nc][cur.crash][cur.daytime + 1] = true;
					continue;
				}
				if (isWall[nr][nc] && cur.daytime == 1 && !isVisited[nr][nc][cur.crash][cur.daytime - 1]) {
					q.add(new Node(nr, nc, cur.dist + 1, cur.crash, cur.daytime - 1));
					isVisited[nr][nc][cur.crash][cur.daytime - 1] = true;
					continue;
				}
				if (!isWall[nr][nc] && cur.crash < K && cur.daytime == 0
						&& !isVisited[nr][nc][cur.crash + 1][cur.daytime + 1]) {
					q.add(new Node(nr, nc, cur.dist + 1, cur.crash + 1, cur.daytime + 1));
					isVisited[nr][nc][cur.crash + 1][cur.daytime + 1] = true;
					continue;
				}
				if (!isWall[nr][nc] && cur.crash < K && cur.daytime == 1
						&& !isVisited[cur.r][cur.c][cur.crash][cur.daytime - 1]) {
					q.add(new Node(cur.r, cur.c, cur.dist + 1, cur.crash, cur.daytime - 1));
					isVisited[cur.r][cur.c][cur.crash][cur.daytime - 1] = true;
				}
			}
		}

		return -1;
	}
}