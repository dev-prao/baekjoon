import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] campus = new char[N][M];
		boolean[][] visited = new boolean[N][M];
		int[] start = new int[2];

		for (int i = 0; i < N; i++) {
			campus[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (campus[i][j] == 'I') {
					start[0] = i;
					start[1] = j;
				} // 도연이 위치 찾음
			}
		}

		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};

		int count = 0;
		Queue<int[]> queue = new LinkedList<>();
		visited[start[0]][start[1]] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr[0] + dr[i];
				int nc = curr[1] + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]
					|| campus[nr][nc] == 'X') {
					continue;
				}

				if (campus[nr][nc] == 'P') {
					count++;
				}
				visited[nr][nc] = true;
				queue.add(new int[] {nr, nc});
			}
		}

		if (count > 0) {
			System.out.println(count);
		} else {
			System.out.println("TT");
		}
	}

}
