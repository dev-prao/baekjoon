import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Movement {
		Coordinate coordinate;
		int beerCnt;

		public Movement(Coordinate coordinate, final int beerCnt) {
			this.coordinate = coordinate;
			this.beerCnt = beerCnt;
		}
	}

	static class Coordinate {
		int r, c;

		public Coordinate(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int T, N, r, c;
	static String res;
	static Coordinate house, festival;
	static boolean[] visit;
	static Coordinate[] store;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//맥주 한 박스 - 20개
		//50미터를 가려면 그 직전에 맥주 한 병 마셔야 함
		//맥주를 더 구매해야 할 수도 있음(편의점)
		//빈병은 버리고 새 맥주 병을 살 수 있음
		//박스에는 최대 20병, 편의점 나선 직후도 50미터를 가기 전 맥주 한 병 마셔야 함
		T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			res = "sad";
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			house = new Coordinate(r, c);
			store = new Coordinate[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				store[i] = new Coordinate(r, c);
			}
			visit = new boolean[N];
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			festival = new Coordinate(r, c);
			bfs();
			System.out.println(res);
		}
	}

	static void bfs() {
		Deque<Movement> q = new ArrayDeque<>();
		q.offer(new Movement(house, 20));
		while (!q.isEmpty()) {
			Movement curr = q.poll();
			if (getDistance(curr.coordinate, festival) <= curr.beerCnt * 50) {
				res = "happy";
				return;
			}
			for (int i = 0; i < N; i++) {
				if (visit[i]) continue;
				Coordinate nextStore = store[i];
				int distance = getDistance(curr.coordinate, nextStore);
				if (distance > curr.beerCnt * 50) continue;
				visit[i] = true;
				q.offer(new Movement(nextStore, 20));
			}
		}
	}

	static int getDistance(Coordinate c1, Coordinate c2) {
		return Math.abs(c1.r - c2.r) + Math.abs(c1.c - c2.c);
	}
}
