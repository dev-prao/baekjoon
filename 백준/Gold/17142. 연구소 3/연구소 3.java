import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;
		int time;

		public Node(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static int N, M, empty;
	static int minTime = Integer.MAX_VALUE;

	static int[][] virus;
	static Node[] active;
	static List<Node> viruses;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		viruses = new ArrayList<>();
		virus = new int[N][N];
		active = new Node[M];
		empty = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				virus[i][j] = Integer.parseInt(st.nextToken());
				if (virus[i][j] == 2) {
					viruses.add(new Node(i, j, 0));
				}
				if (virus[i][j] == 0) {
					empty++;
				}
			}
		}

		if (empty == 0) System.out.println(0);
		else {
			comb(0, 0);
			System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
		}
	}

	private static void comb(int start, int depth) {
		if (depth == M) {
			spread(empty);
			return;
		}

		for (int i = start; i < viruses.size(); i++) {
			active[depth] = viruses.get(i);
			comb(i + 1, depth + 1);
		}
	}

	private static void spread(int empty) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		for (int i = 0; i < M; i++) {
			Node v = active[i];
			visit[v.r][v.c] = true;
			queue.add(v);
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				Node cur = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur.r + dr[d];
					int nc = cur.c + dc[d];

					if (isOutOfMap(nr,nc) || visit[nr][nc] || virus[nr][nc] == 1) continue;
					if (virus[nr][nc] == 0) empty--;
					if (empty == 0) {
						minTime = Math.min(minTime, cur.time + 1);
						return;
					}

					visit[nr][nc] = true;
					queue.add(new Node(nr, nc, cur.time + 1));
				}
			}
		}
	}

	static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}
}
