import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] bucket;
	static int[][] move = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static boolean[][] visit;
	static Queue<Cloud> clouds = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bucket = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				bucket[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clouds.add(new Cloud(N - 1, 0));
		clouds.add(new Cloud(N - 1, 1));
		clouds.add(new Cloud(N - 2, 0));
		clouds.add(new Cloud(N - 2, 1));

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			visit = new boolean[N][N];

			for (Cloud cloud : clouds) {
				cloud.x = (N + (cloud.x + move[d][0] * s) % N) % N;
				cloud.y = (N + (cloud.y + move[d][1] * s) % N) % N;
				bucket[cloud.x][cloud.y]++;
			}

			while (!clouds.isEmpty()) {
				Cloud cloud = clouds.poll();
				int cnt = 0;
				visit[cloud.x][cloud.y] = true;

				for (int i = 1; i <= 7; i += 2) {
					int nx = cloud.x + move[i][0];
					int ny = cloud.y + move[i][1];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N || bucket[nx][ny] == 0) {
						continue;
					}
					cnt++;
				}
				bucket[cloud.x][cloud.y] += cnt;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] || bucket[i][j] < 2) {
						continue;
					}
					bucket[i][j] -= 2;
					clouds.add(new Cloud(i, j));
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += bucket[i][j];
			}
		}
		System.out.println(result);

		br.close();
	}

	public static class Cloud {
		int x;
		int y;

		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}