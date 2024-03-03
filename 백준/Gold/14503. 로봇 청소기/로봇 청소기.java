import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 방의 크기 N X M (0,0) ~ (N-1,M-1)
 * 각각의 칸은 벽 또는 빈 칸
 * 청소기가 바라보는 방향 동, 서, 남, 북 중 하나
 *
 * 1. 작동 과정
 *   (1) 현재 칸이 아직 청소되지 않은 경우 -> 현재칸 청소
 *   (2) 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
 *     (a) 바라보는 방향 유지, 한 칸 후진 가능하면 한 칸 후진하고 (1)으로 돌아감
 *     (b) 바라보는 방향의 뒤쪽 칸이 벽(후진 불가) -> 작동 멈춤
 *   (3) 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
 *     (a) 반시계 방향으로 90도 회전
 *     (b) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
 *     (c) 1번으로 돌아감
 */

public class Main {

	static class Vacuum {
		int r, c, dir;

		public Vacuum(final int r, final int c, final int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
	}

	static int N, M, res;
	static Vacuum vacuum;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1, 0}; //0(북) 1(동) 2(남) 3(서)
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		vacuum = new Vacuum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
			Integer.parseInt(st.nextToken()));
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Deque<Vacuum> q = new ArrayDeque<>();
		q.offer(vacuum);
		while (!q.isEmpty()) {
			Vacuum curr = q.poll();
			// (1) 현재 칸이 아직 청소되지 않은 경우 -> 현재칸 청소
			if (map[curr.r][curr.c] == 0) {
				map[curr.r][curr.c] = 2;
				res++;
			}
			// (2) 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				if (isNotValid(nr, nc)) continue;
				if (map[nr][nc] == 0) cnt++;
			}
			//   (a) 바라보는 방향 유지, 한 칸 후진 가능하면 한 칸 후진하고 (1)으로 돌아감
			if (cnt == 0) {
				int nr = curr.r - dr[curr.dir];
				int nc = curr.c - dc[curr.dir];
				//   (b) 바라보는 방향의 뒤쪽 칸이 벽(후진 불가) -> 작동 멈춤
				if (isNotValid(nr, nc) || map[nr][nc] == 1) continue;
				q.offer(new Vacuum(nr, nc, curr.dir));
				continue;
			}
			// (3) 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			//   (a) 반시계 방향으로 90도 회전
			//   (b) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
			//   (c) 1번으로 돌아감
			int dir = (curr.dir + 3) % 4;
			int nr = curr.r + dr[dir];
			int nc = curr.c + dc[dir];
			if (isNotValid(nr, nc)) continue;
			if (map[nr][nc] == 0) {
				q.offer(new Vacuum(nr, nc, dir));
			} else {
				q.offer(new Vacuum(curr.r, curr.c, dir));
			}
		}
		System.out.println(res);
	}

	static boolean isNotValid(int r, int c) {
		return r < 0 || c < 0 || r >= N && c >= M;
	}
}
