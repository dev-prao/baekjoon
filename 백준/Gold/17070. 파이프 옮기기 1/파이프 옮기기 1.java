import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	1. 파이프는 2개의 연속된 칸을 차지
	ex) 1 1  1 0  1 0
	    0 0  1 0  0 1
	2. 파이프가 벽을 긁으면 안됨(파이프는 항상 빈 칸만 차지해야함)
	3. 파이프를 미는 방법: 우(0,1), 우하(1,1), 하(1,0)
	4. 파이프는 밀면서 회전 가능(회전은 45도만 가능)
	5. 이동 방법
	  1) 파이프가 가로로 놓여진 경우: 2가지
	  2) 파이프가 세로로 놓여진 경우: 2가지
	  3) 파이프가 대각선으로 놓여진 경우: 3가지
 	6. 가장 처음에 (0,0), (0,1) 차지, 방향은 가로.
 	파이프의 한쪽 끝을 (N-1,N-1)로 이동시키는 방법의 개수를 구하라.
	 */

	static class Pipe {
		Point start, end;
		int dir;

		public Pipe(final Point start, final Point end, final int dir) {
			this.start = start;
			this.end = end;
			this.dir = dir;
		}
	}

	static class Point {
		int r, c;

		public Point(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, res;
	static int[][] map;
	static int[][] move = {{0, 1}, {1, 0}, {1, 1}}; //우, 하, 우하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		Pipe p = new Pipe(new Point(0, 0), new Point(0, 1), 0);
		// Deque<Pipe> q = new ArrayDeque<>();
		// q.offer(p);
		// while (!q.isEmpty()) {
		// 	Pipe curr = q.poll();
		// 	if (curr.end.r == N - 1 && curr.end.c == N - 1) {
		// 		res++;
		// 		continue;
		// 	}
		// 	if ((curr.end.r == N - 1 && curr.dir == 1) || (
		// 		curr.end.c == N - 1 && curr.dir == 0)) continue;
		// 	if (curr.dir == 0) {
		// 		for (int dir = 0; dir < 3; dir++) {
		// 			if (dir == 1) continue;
		// 			Pipe pipe = getPipe(curr, dir);
		// 			if (pipe != null) {
		// 				q.offer(pipe);
		// 			}
		// 		}
		// 		continue;
		// 	}
		// 	if (curr.dir == 1) {
		// 		for (int dir = 0; dir < 3; dir++) {
		// 			if (dir == 0) continue;
		// 			Pipe pipe = getPipe(curr, dir);
		// 			if (pipe != null) {
		// 				q.offer(pipe);
		// 			}
		// 		}
		// 		continue;
		// 	}
		// 	if (curr.dir == 2) {
		// 		for (int dir = 0; dir < 3; dir++) {
		// 			Pipe pipe = getCroosPipe(curr, dir);
		// 			if (pipe != null) {
		// 				q.offer(pipe);
		// 			}
		// 		}
		// 	}
		// }
		dfs(p);
		System.out.println(res);
	}

	static void dfs(Pipe curr) {
		if (curr.end.r == N - 1 && curr.end.c == N - 1) {
			res++;
			return;
		}
		if ((curr.end.r == N - 1 && curr.dir == 1) || (
			curr.end.c == N - 1 && curr.dir == 0)) return;
		if (curr.dir == 0) {
			for (int dir = 0; dir < 3; dir++) {
				if (dir == 1) continue;
				Pipe pipe = getPipe(curr, dir);
				if (pipe != null) {
					dfs(pipe);
				}
			}
			return;
		}
		if (curr.dir == 1) {
			for (int dir = 0; dir < 3; dir++) {
				if (dir == 0) continue;
				Pipe pipe = getPipe(curr, dir);
				if (pipe != null) {
					dfs(pipe);
				}
			}
			return;
		}
		if (curr.dir == 2) {
			for (int dir = 0; dir < 3; dir++) {
				Pipe pipe = getCroosPipe(curr, dir);
				if (pipe != null) {
					dfs(pipe);
				}
			}
		}
	}

	static Pipe getPipe(Pipe pipe, int dir) {
		int ner = pipe.end.r + move[dir][0];
		int nec = pipe.end.c + move[dir][1];
		if (ner >= N || nec >= N || map[ner][nec] == 1 || (dir == 2 && (
			(ner - 1 >= 0 && map[ner - 1][nec] == 1)
				|| (nec - 1 >= 0 && map[ner][nec - 1] == 1)))) return null;
		if (dir == 0 || dir == 1) return new Pipe(pipe.end, new Point(ner, nec), dir);
		return new Pipe(pipe.end, new Point(ner, nec), 2);
	}

	static Pipe getCroosPipe(Pipe pipe, int dir) {
		if (dir == 0) {
			int ner = pipe.end.r + move[dir][0];
			int nec = pipe.end.c + move[dir][1];
			if (ner >= N || nec >= N || map[ner][nec] == 1) return null;
			return new Pipe(pipe.end, new Point(ner, nec), 0);
		}
		if (dir == 1) {
			int ner = pipe.end.r + move[dir][0];
			int nec = pipe.end.c + move[dir][1];
			if (ner >= N || nec >= N || map[ner][nec] == 1) return null;
			return new Pipe(pipe.end, new Point(ner, nec), 1);
		}
		int ner = pipe.end.r + move[2][0];
		int nec = pipe.end.c + move[2][1];
		if (ner >= N || nec >= N || map[ner][nec] == 1 || (ner - 1 >= 0
			&& map[ner - 1][nec] == 1)
			|| (nec - 1 >= 0 && map[ner][nec - 1] == 1)) return null;
		return new Pipe(pipe.end, new Point(ner, nec), 2);
	}
}
