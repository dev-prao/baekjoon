import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		int[][] map = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] mapInfo = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(mapInfo[j]);
			}
		}

		int cnt = 0;
		int max = 0;
		int[] dr = {-1, 0, 0, 1};
		int[] dc = {0, -1, 1, 0};
		Deque<int[]> q;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0 || visit[i][j]) continue;

				visit[i][j] = true;
				int area = 1;

				q = new ArrayDeque<>();
				q.offer(new int[] {i, j});
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];
						if(nr < 0 || nc < 0 || nr >= n || nc >= m || map[nr][nc] == 0 || visit[nr][nc]) continue;
						q.offer(new int[] {nr, nc});
						if(!visit[nr][nc]) area++;
						visit[nr][nc] = true;
					}
				}
				cnt++;
				max = Math.max(max, area);
			}
		}

		if (cnt == 0) {
			System.out.println(0);
			System.out.println(0);
			return;
		}

		System.out.println(cnt);
		System.out.print(max);
	}
}
