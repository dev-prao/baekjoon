import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] board = new int[R][C];
		boolean[][] isVisited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int N = Integer.parseInt(br.readLine());
		int[] dr = new int[N];
		int[] dc = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			dr[i] = Integer.parseInt(st.nextToken());
			dc[i] = Integer.parseInt(st.nextToken());
		}

		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < C; i++) {
			if (board[0][i] != 1) {
				continue;
			}
			queue.add(new int[] {0, i, 0});
			isVisited[0][i] = true;
		}
		//r,c,dist
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			if (curr[0] == R - 1) {
				System.out.println(curr[2]);
				System.exit(0);
			}

			for (int j = 0; j < N; j++) {
				int nr = curr[0] + dr[j];
				int nc = curr[1] + dc[j];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || board[nr][nc] != 1
					|| isVisited[nr][nc]) {
					continue;
				}
				queue.add(new int[] {nr, nc, curr[2] + 1});
				isVisited[nr][nc] = true;
			}
		}
		System.out.println(-1);
		br.close();
	}
}
