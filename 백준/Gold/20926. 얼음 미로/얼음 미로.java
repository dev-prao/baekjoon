import static java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	// 테라: 탐험가. 상하좌우 이동. 최초 위치한 빙판의 미끌 시간은 0
	// 바위: 통과 x. 미끄러지거나 부딪히면 앞에서 멈춤
	// 구멍: 빠지면 영영 탈출 불가
	// 출구: 방문 즉시 얼음 미로 탈출
	// 미끌 시간: 미끄러지는데 걸리는 시간
	// 어느 한쪽 방향으로 이동시, 미끄러지는 동안 위치한 빙판의 미끌 시간을 더하면 이동 시간
	// 이동시간 관련 규칙
	// 1. 어느 한쪽 방향으로 이동을 시작할 때, 시작 빙판의 미끌 시간은 포함 x
	// 2. 출구로 들어갈 때, 출구 빙판의 미끌 시간은 포함 X

	static class Point {
		int r, c, time;

		public Point(final int r, final int c, final int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	static int W, H;
	static int min = Integer.MAX_VALUE;
	static char[][] map;
	static boolean[][] visit;
	static Point tera, temp;
	static boolean isTempChanged;
	// 상, 하, 좌, 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mapSize = br.readLine().split(" ");
		W = Integer.parseInt(mapSize[0]);
		H = Integer.parseInt(mapSize[1]);
		map = new char[H][W];
		visit = new boolean[H][W];
		for (int r = 0; r < H; r++) {
			String input = br.readLine();
			for (int c = 0; c < W; c++) {
				map[r][c] = input.charAt(c);
				if (map[r][c] == 'T') tera = new Point(r, c, 0);
			}
		}

		PriorityQueue<Point> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
		q.offer(tera);

		while (!q.isEmpty()) {
			//상하좌우 체크
			Point curr = q.poll();
			if (visit[curr.r][curr.c]) continue;
			visit[curr.r][curr.c] = true;

			for (int dir = 0; dir < 4; dir++) {
				move(curr, dir);
				if (isTempChanged) {
					q.offer(temp);
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			out.println("-1");
		} else {
			out.println(min);
		}
	}

	static void move(Point curr, int dir) {
		int nr = curr.r;
		int nc = curr.c;
		int time = 0;
		isTempChanged = false;
		boolean crash = false;

		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			if (isInvalidRange(nr, nc) || map[nr][nc] == 'H') break;
			if (map[nr][nc] == 'R') {
				crash = true;
				break;
			}
			if (map[nr][nc] == 'E') {
				min = Math.min(min, curr.time + time);
				break;
			}
			time += (map[nr][nc] - '0');
		}

		nr -= dr[dir];
		nc -= dc[dir];
		// out.println("[" + nr + "][" + nc + "]");
		// 충돌했고, 움직임이 있다면 큐에 시간을 업데이트해서 추가
		if (crash && !(nr == curr.r && nc == curr.c)) {
			temp = new Point(nr, nc, curr.time + time);
			isTempChanged = true;
		}
	}

	static boolean isInvalidRange(int r, int c) {
		return r < 0 || c < 0 || r >= H || c >= W;
	}
}
