import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dz = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 0, 1 };
	static int[] dx = { 0, 0, 1, 0, -1, 0 };
	static int M, N, H, day, size;
	static int[][][] box;
	static boolean isRipened = true;
	static Queue<Point> queue = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		for (int z = 0; z < H; z++) {
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					box[z][y][x] = Integer.parseInt(st.nextToken());
					if (box[z][y][x] == 1)
						queue.add(new Point(z, y, x));
					if (box[z][y][x] == 0)
						isRipened = false;
				}
			}
		}

		if (isRipened) {
			System.out.println(0);
			return;
		}

		bfs();
		check();

		System.out.println(day);
	}

	static void bfs() {
		int cnt = queue.size();
		while (!queue.isEmpty()) {
			if (cnt == 0) {
				cnt = queue.size();
				day++;
			}
			Point node = queue.poll();
			cnt--;
			for (int d = 0; d < 6; d++) {
				int nz = node.z + dz[d];
				int ny = node.y + dy[d];
				int nx = node.x + dx[d];
				if (nz < 0 || nz >= H || nx < 0 || nx >= M || ny < 0 || ny >= N || box[nz][ny][nx] != 0)
					continue;
				queue.add(new Point(nz, ny, nx));
				box[nz][ny][nx] = 1;
			}
		}
	}

	static void check() {
		for (int z = 0; z < H; z++) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if (box[z][y][x] == 0)
						day = -1;
				}
			}
		}
	}

	static class Point {
		int x, y, z;

		public Point(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
}