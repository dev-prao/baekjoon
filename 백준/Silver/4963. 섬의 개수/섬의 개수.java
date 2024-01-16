import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static int[][] mapOfLand;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int count = 0;

			if (w == 0 && h == 0) {
				break;
			}

			mapOfLand = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					mapOfLand[i][j] = Integer.parseInt(st.nextToken());
					;
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (mapOfLand[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
		br.close();
	}

	private static void dfs(int x, int y) {
		mapOfLand[x][y] = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (stay(nx, ny)) {
				continue;
			}
			dfs(nx, ny);
		}
	}

	private static boolean stay(int x, int y) {
		return isOutOfRange(x, y) || mapOfLand[x][y] != 1;
	}

	private static boolean isOutOfRange(int x, int y) {
		return x < 0 || y < 0 || x == h || y == w;
	}

}