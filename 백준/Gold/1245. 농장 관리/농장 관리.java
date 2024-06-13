import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;

	static Deque<int[]> q;

	static int[][] map;
	static boolean[][] isVisited, isPeak;

	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isVisited = new boolean[N][M];
		isPeak = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !isPeak[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(answer);
	}

	static void bfs(int r, int c) {
		for (int row = 0; row < N; row++) {
			Arrays.fill(isVisited[row], false);
		}
		isVisited[r][c] = true;

		q = new ArrayDeque<>();
		q.add(new int[]{r,c});
		List<int[]> peaks = new ArrayList<>();

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 8; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (isValid(nr, nc) && !isVisited[nr][nc]) {
					if (map[nr][nc] > map[cur[0]][cur[1]]) return;
					if (map[nr][nc] == map[cur[0]][cur[1]]) {
						q.add(new int[]{nr,nc});
						peaks.add(new int[]{nr, nc});
					}
					isVisited[nr][nc] = true;
				}
			}
		}

		for (int[] peak : peaks) {
			isPeak[peak[0]][peak[1]] = true;
		}

		answer++;
	}

	static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
