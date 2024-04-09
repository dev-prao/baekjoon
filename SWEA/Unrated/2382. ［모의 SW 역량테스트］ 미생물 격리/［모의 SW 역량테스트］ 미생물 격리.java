import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static PriorityQueue<Cell> q;
	static Cell[][] map;
	static int N, M, K, total;
	static int[] turn = { 0, 2, 1, 4, 3 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static int[] dr = { 0, -1, 1, 0, 0 };
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			total = 0;
			st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new Cell[N][N];
			q = new PriorityQueue<Cell>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				q.add(new Cell(r, c, num, dir));
			}

			sb.append(move()).append("\n");
		}
		System.out.println(sb);
	}

	static int move() {
		int time = M;
		total = 0;
		while (time > 0) {
			Cell head;
			while (!q.isEmpty()) {
				head = q.poll();
				int nr = head.c += dr[head.way];
				int nc = head.r += dc[head.way];
				// 가장자리면 감소하고 턴 한다.
				if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {
					head.num /= 2;
					if (head.num == 0) continue;
					head.way = turn[head.way];
				}

				if (map[nr][nc] == null) {
					map[nr][nc] = head;
				} else {
					map[nr][nc].num += head.num;
				}

			}
			total = reset();
			time--;
		}

		return total;
	}

	private static int reset() {
		int temp = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != null) {
					q.offer(map[r][c]);
					temp += map[r][c].num;
					map[r][c] = null;
				}
			}
		}
		return temp;
	}

	static class Cell implements Comparable<Cell> {
		int r, c, num, way;

		public Cell(int c, int r, int num, int way) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.way = way;
		}

		@Override
		public int compareTo(Cell o) {
			return o.num - this.num; // 내림차순
		}

	}
}