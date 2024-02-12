import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Main {

	static int N;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[][] map;

	static Deque<int[]> queue = new ArrayDeque<>();
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					result.add(bfs(new int[] {i, j}));
				}
			}
		}

		Collections.sort(result);

		sb.append(result.size()).append("\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int bfs(int[] point) {
		int result = 0;
		queue.add(point);
		map[point[0]][point[1]] = -1;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			result++;
			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 1) {
					continue;
				}
				map[nx][ny] = -1;
				queue.add(new int[] {nx, ny});
			}
		}
		return result;
	}
}
