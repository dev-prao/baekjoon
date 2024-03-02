import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c;

		public Point(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, D;
	static int[][] map;
	static int[][] copyMap;
	static boolean[] defender;
	static boolean[] isAttack;
	static Point[] defPoint;
	static List<Point> atkPoint;
	static int res = -1;
	private static final int DEF_COUNT = 3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //row
		M = Integer.parseInt(st.nextToken()); //col
		D = Integer.parseInt(st.nextToken()); //궁수의 사정거리
		map = new int[N][M];
		copyMap = new int[N][M];
		defender = new boolean[M];
		defPoint = new Point[DEF_COUNT];
		atkPoint = new ArrayList<>();
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				copyMap[r][c] = map[r][c];
				if (map[r][c] == 1) atkPoint.add(new Point(r, c));
			}
		}
		Collections.sort(atkPoint, (o1, o2) -> o1.r != o2.r ? o2.r - o1.r : o1.c - o2.c);
		dfs(0, 0);
		System.out.println(res);
	}

	public static void init() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = copyMap[r][c];
			}
		}
	}

	static void dfs(int idx, int cnt) {
		if (idx == M && cnt != DEF_COUNT) return;
		if (cnt == DEF_COUNT) {
			init();
			// System.out.println(Arrays.toString(defender));
			// System.out.println(res);
			res = Math.max(res, getScore());
			return;
		}

		defender[idx] = true;
		dfs(idx + 1, cnt + 1);
		defender[idx] = false;
		dfs(idx + 1, cnt);
	}

	static int getScore() {
		int score = 0;
		int idx = 0;
		//궁수의 위치를 저장
		for (int i = 0; i < M; i++) {
			if (defender[i]) {
				defPoint[idx++] = new Point(N, i);
			}
		}
		while (true) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) cnt++;
				}
			}
			if (cnt == 0) break;
			isAttack = new boolean[DEF_COUNT];
			//적과 궁수의 거리 계산하여 공격할 수 있는지 확인
			int[][] info = {{N, M, Integer.MAX_VALUE}, {N, M, Integer.MAX_VALUE},
				{N, M, Integer.MAX_VALUE}};
			for (int i = 0; i < DEF_COUNT; i++) {
				Point curr = defPoint[i];
				for (int r = N - 1; r >= 0; r--) {
					for (int c = 0; c < M; c++) {
						if (map[r][c] == 1) {
							//공격할 대상 찾기
							Point atkPoint = new Point(r, c);
							int dist = getDist(atkPoint, curr);
							if (dist <= D && (dist <= info[i][2])) {
								if (dist == info[i][2] && c > info[i][1]) continue;
								info[i] = new int[] {r, c, dist};
							}
						}
					}
				}
			}

			for (int i = 0; i < DEF_COUNT; i++) {
				if (info[i][2] == Integer.MAX_VALUE) continue;
				int r = info[i][0];
				int c = info[i][1];
				if (map[r][c] == 1) {
					map[r][c] = 0;
					score++;
				}
			}

			// 공격이 끝나면 한칸 아래로
			// System.out.println("====공격 후 맵====");
			// for (int i = 0; i < N; i++) {
			// 	for (int j = 0; j < M; j++) {
			// 		System.out.print("[" + map[i][j] + "]");
			// 	}
			// 	System.out.println();
			// }
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
						if (i + 1 >= N) continue;
						map[i + 1][j] = 1;
					}
				}
			}
			// System.out.println("현재 점수 : " + score);
			// System.out.println("====이동 후 맵====");
			// for (int i = 0; i < N; i++) {
			// 	for (int j = 0; j < M; j++) {
			// 		System.out.print("[" + map[i][j] + "]");
			// 	}
			// 	System.out.println();
			// }
		}
		return score;
	}

	static int getDist(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}
}
