import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	static class Ice {
		int r, c, height, cnt;

		public Ice(final int r, final int c, final int height) {
			this.r = r;
			this.c = c;
			this.height = height;
		}

		@Override
		public String toString() {
			return "위치 : [" + r +
				"][" + c +
				"] height : " + height +
				", cnt : " + cnt;
		}
	}

	static int N, M, year, check;
	static Ice start;
	static int[][] map;
	static boolean[][] visit;
	static List<Ice> ices;
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		N = Integer.parseInt(inputs[0]);
		M = Integer.parseInt(inputs[1]);
		map = new int[N][M];
		ices = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			String[] input = br.readLine().split(" ");
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(input[c]);
				if (map[r][c] > 0) {
					ices.add(new Ice(r, c, map[r][c]));
				}
			}
		}

		// 1. 주위의 바닷물이 있는 칸 개수를 저장한다.
		while (true) {
			int iceCnt = 0;
			// for (Ice ice : ices) {
			// 	System.out.println(ice);
			// }
			// 빙산이 분리된다면 분리되는 최초의 시간(년) 출력
			// 분리되지 않으면 0 출력
			Deque<Ice> q = new ArrayDeque<>();
			for (Ice ice : ices) {
				if (ice.height > 0) {
					start = ice;
					break;
				}
			}
			q.offer(start);
			check = 1;
			visit = new boolean[N][M];
			visit[start.r][start.c] = true;
			//연결된 얼음의 개수 세기
			while (!q.isEmpty()) {
				Ice curr = q.poll();
				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];
					if (isInvalidRange(nr, nc) || visit[nr][nc] || map[nr][nc] <= 0) continue;
					// System.out.println("큐에 넣는 좌표 : [" + nr + "][" + nc + "]");
					visit[nr][nc] = true;
					check++;
					q.offer(new Ice(nr, nc, map[nr][nc]));
				}
			}
			// System.out.println("======= 현재빙산 =======");
			// for (int i = 0; i < N; i++) {
			// 	for (int j = 0; j < M; j++) {
			// 		System.out.print(map[i][j]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println("======= 방문체크 =======");
			// for (int i = 0; i < N; i++) {
			// 	for (int j = 0; j < M; j++) {
			// 		if (visit[i][j]) {
			// 			System.out.print("1");
			// 		} else {
			// 			System.out.print("0");
			// 		}
			// 	}
			// 	System.out.println();
			// }

			//높이가 1 이상인 얼음의 개수 세기
			for (Ice ice : ices) {
				if (ice.height <= 0) continue;
				iceCnt++;
			}
			// System.out.println("연결된 얼음의 개수 : " + check);
			// System.out.println("높이가 1 이상인 얼음의 개수 : " + iceCnt);

			//연결된 얼음의 개수와 총 얼음의 개수가 다르면(연결되지 않은게 존재한다면)
			if (check != iceCnt) {
				System.out.println(year);
				return;
			}

			//주위를 둘러싼 바닷물이 있는 칸 개수 세기
			for (Ice ice : ices) {
				int cnt = 0;
				if (ice.height <= 0) continue;
				for (int d = 0; d < 4; d++) {
					int nr = ice.r + dr[d];
					int nc = ice.c + dc[d];
					if (isInvalidRange(nr, nc)) continue;
					if (map[nr][nc] == 0) cnt++;
				}
				ice.cnt = cnt;
			}

			// 2. 바닷물이 있는 칸 개수만큼 빙산의 높이를 감소시킨다.
			for (Ice ice : ices) {
				if (ice.height <= 0 || ice.cnt == 0) continue;
				ice.height -= ice.cnt;
				if (ice.height <= 0) ice.height = 0;
				ice.cnt = 0;
				map[ice.r][ice.c] = ice.height;
			}

			int ic = 0;
			for (Ice ice : ices) {
				if (ice.height <= 0) continue;
				ic++;
			}

			if (ic == 0) {
				System.out.println("0");
				return;
			}

			year += 1;
		}
	}

	static boolean isInvalidRange(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
}
