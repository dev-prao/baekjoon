import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dx = {-1, 0, 0, 1};
		int[] dy = {0, -1, 1, 0};
		int[][] map = new int[N][M];
		boolean[][] isVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(input[j]));
			}
		}

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0, 1});
		isVisited[0][0] = true;
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			if (point[0] == N - 1 && point[1] == M - 1) {
				System.out.println(point[2]);
				br.close();
				System.exit(0);
			}
			for (int i = 0; i < 4; i++) {
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0
					|| isVisited[nx][ny]) {
					continue;
				}
				queue.add(new int[] {nx, ny, point[2] + 1});
				isVisited[nx][ny] = true;
			}
		}
	}
}
