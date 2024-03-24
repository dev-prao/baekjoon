import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, G, R, result;
	static int[][] map;
	static List<int[]> ground;

	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		ground = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					ground.add(new int[] {i, j});
				}
			}
		}
		result = 0;

		find(0, G, R, ground.size() - G - R, new int[ground.size()]);
		System.out.println(result);
	}

	static void find(int cnt, int green, int red, int blank, int[] check) {
		if (cnt == ground.size()) {
			bfs(check);
			return;
		}
		// 가능한 모든 배양액의 조합을 찾기 위해 재귀적으로 조합을 생성
		if (green != 0) {
			check[cnt] = 1; // 1: 초록색 배양액
			find(cnt + 1, green - 1, red, blank, check);
		}
		if (red != 0) {
			check[cnt] = 2; // 2: 빨간색 배양액
			find(cnt + 1, green, red - 1, blank, check);
		}
		if (blank != 0) {
			check[cnt] = 0; // 0: 배양액 없음
			find(cnt + 1, green, red, blank - 1, check);
		}
	}

	static void bfs(int[] check) {
		int num = 0;
		Deque<int[]> queue = new ArrayDeque<>();
		//visit[x][y][0]: 초기상태
		//visit[x][y][1]: 초록색 배양액
		//visit[x][y][2]: 빨간색 배양액
		int[][][] visit = new int[N][M][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j][1] = Integer.MAX_VALUE; // 초록색 배양액 초기화
				visit[i][j][2] = Integer.MAX_VALUE; // 빨간색 배양액 초기화
			}
		}

		//그라운드 순회
		for (int i = 0; i < ground.size(); i++) {
			if (check[i] != 0) { //배양액이 뿌려진 경우
				int[] now = ground.get(i); //배양액 뿌려진 좌표
				queue.add(new int[] {now[0], now[1], check[i], 0}); //좌표와 값(초록1) 또는 빨강(2), 시간
				visit[now[0]][now[1]][check[i]] = 0; // 초록색 또는 빨간색 배양액 방문처리(0)
			}
		}

		// BFS 탐색
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			// 현재 위치가 꽃이라면(꽃 : -1) 스킵
			if (visit[now[0]][now[1]][now[2]] == -1) continue;

			// 네 방향으로 이동하면서 배양액을 퍼뜨림
			for (int d = 0; d < 4; d++) {
				int nr = now[0] + delta[d][0];
				int nc = now[1] + delta[d][1];
				int op = now[2] == 1 ? 2 : 1; // 초록이면 빨강, 빨강이면 초록
				// 맵 범위를 벗어나면 제외
				if (nr >= N || nr < 0 || nc >= M || nc < 0) continue;

				// 초록색이거나 빨간색으로 배양액이 뿌려진 경우 건너뜀
				if (visit[nr][nc][op] < now[3] + 1 || visit[nr][nc][now[2]] <= now[3] + 1
					|| map[nr][nc] == 0)
					continue;

				// 이전에 초록색 또는 빨간색 배양액이 이미 도달한 경우라면
				if (visit[nr][nc][op] == now[3] + 1) {
					visit[nr][nc][op] = -1; // 이미 방문한 위치를 표시하기 위해 -1로 설정
					visit[nr][nc][now[2]] = -1;
				} else {
					visit[nr][nc][now[2]] = now[3] + 1;
					queue.add(new int[] {nr, nc, now[2], now[3] + 1});
				}
			}
		}

		// 최종적으로 퍼뜨린 배양액의 수를 계산하여 결과를 업데이트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visit[i][j][1] == -1) num++;
			}
		}
		result = Math.max(result, num); // 최대값 갱신
	}
}
