import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, houseCount;
	static boolean[] visit;
	static int[][] map;
	static List<int[]> store;
	static List<House> house;

	static int chickenDist = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		store = new ArrayList<>();
		house = new ArrayList<>();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					house.add(new House(i, j));
					// System.out.println("집의 위치 [" + i + "][" + j + "]");
				} else if (map[i][j] == 2) {
					store.add(new int[] {i, j});
					// System.out.println("치킨집의 위치 [" + i + "][" + j + "]");
				}
			}
		}

		houseCount = house.size();
		visit = new boolean[store.size()];
		// System.out.println("집의 개수 : " + houseCount);
		// System.out.println("치킨집의 개수 : " + store.size());

		dfs(0, 0);
		bw.write(String.valueOf(chickenDist));
		bw.close();
		br.close();
	}

	static void dfs(int index, int count) {
		if (count == M) {
			bfs();
			// for (int i = 0; i < visit.length; i++) {
			// 	System.out.println(i + "번째 치킨집 방문 여부 : " + visit[i]);
			// }
			return;
		}

		if (index == visit.length) {
			return;
		}

		visit[index] = true;
		dfs(index + 1, count + 1);
		visit[index] = false;
		dfs(index + 1, count);
	}

	static void bfs() {
		int sum = 0;
		Deque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < visit.length; i++) {
			if (visit[i]) {
				q.offer(store.get(i));
				// System.out.println(
				// 	i + "번째 치킨집 추가, 위치 [" + store.get(i)[0] + "][" + store.get(i)[1] + "]");
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (House h : house) {
				int d = Math.abs(h.r - curr[0]) + Math.abs(h.c - curr[1]);
				// System.out.print("집과 치킨집 사이의 거리 : " + d + ", 기존의 거리 : " + h.dist);
				h.dist = Math.min(h.dist, d);
				// System.out.println(", 업데이트 거리 : " + h.dist);
			}
		}

		for (House h : house) {
			sum += h.dist;
		}
		// System.out.println("bfs 수행 후 합계 : " + sum);
		chickenDist = Math.min(chickenDist, sum);
		// System.out.println("업데이트 치킨 거리 : " + chickenDist);

		for (House h : house) {
			h.dist = Integer.MAX_VALUE;
		}
	}

	static class House {
		int r;
		int c;
		int dist;

		public House(final int r, final int c) {
			this.r = r;
			this.c = c;
			this.dist = Integer.MAX_VALUE;
		}
	}
}
