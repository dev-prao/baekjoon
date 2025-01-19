import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, sharkRow, sharkCol, sharkSize = 2, time, eat = 0;
	static int[][] map;
	static boolean[][] isVisited;

	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					sharkRow = i;
					sharkCol = j;
					map[i][j] = 0;
				}
			}
		}

		int totalTime = 0;
		while(isMovable()) {
			totalTime += time;
		}

		System.out.println(totalTime);
	}

	public static boolean isMovable() {
		time = 0;
		if(eat == sharkSize) {
			eat = 0;
			sharkSize++;
		}

		isVisited = new boolean[N][N];

		Deque<Shark> q = new ArrayDeque<>();
		q.offer(new Shark(sharkRow, sharkCol, 0));
		int minRow = Integer.MAX_VALUE;
		int minCol = Integer.MAX_VALUE;
		int minTime = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Shark cur = q.poll();
			if (cur.time >= minTime) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				if (isOutOfMap(nr, nc) || isVisited[nr][nc] || sharkSize < map[nr][nc]) {
					continue;
				}

				if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
					if (nr < minRow) {
						minRow = nr;
						minCol = nc;
						minTime = cur.time + 1;
					} else if (nr == minRow && nc < minCol) {
						minCol = nc;
						minTime = cur.time + 1;
					}
				}

				q.offer(new Shark(nr, nc, cur.time + 1));
				isVisited[nr][nc] = true;
			}
		}

		if (minTime == Integer.MAX_VALUE) {
			return false;
		}

		sharkRow = minRow;
		sharkCol = minCol;
		time = minTime;
		eat++;
		map[sharkRow][sharkCol] = 0;
		return true;
	}

	public static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}
}

class Shark {
	int r, c, time;

	public Shark(int r, int c, int time) {
		this.r = r;
		this.c = c;
		this.time = time;
	}
}
