import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static class Node {
		int r, c;

		public Node(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map, levelMap;
	static boolean[][] visit;

	static int lv = 1;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		M = Integer.parseInt(info[1]);
		map = new int[N][M];
		levelMap = new int[N][M];
		visit = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			String line = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] != 0 || visit[r][c]) continue;
				fill(r, c);
				lv++;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(visit[r][c]) continue;
				Set<Integer> set = new HashSet<>();
				for (int d = 0; d < delta.length; d++) {
					int nr = r + delta[d][0];
					int nc = c + delta[d][1];
					if(isOutOfMap(nr,nc) || !visit[nr][nc] || set.contains(levelMap[nr][nc])) continue;
					set.add(levelMap[nr][nc]);
					map[r][c] += map[nr][nc];
				}
				map[r][c] %= 10;
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(visit[r][c]) {
					sb.append(0);
					continue;
				}
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void fill(int r, int c) {
		Deque<Node> q = new ArrayDeque<>();
		Deque<Node> nodeLevel = new ArrayDeque<>();
		q.offer(new Node(r, c));
		visit[r][c] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			nodeLevel.offer(cur);
			levelMap[cur.r][cur.c] = lv;
			for (int d = 0; d < delta.length; d++) {
				int nr = cur.r + delta[d][0];
				int nc = cur.c + delta[d][1];
				if(isOutOfMap(nr,nc) || map[nr][nc] == 1 || visit[nr][nc]) continue;
				visit[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}
		}

		int size = nodeLevel.size();
		while (!nodeLevel.isEmpty()) {
			Node cur = nodeLevel.poll();
			map[cur.r][cur.c] = size;
		}
	}

	static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
}
