import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] grid;
	static boolean[][] isVisited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int[] count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];
		isVisited = new boolean[N][N];
		count = new int[2]; // 0:R, 1:G, 2:B
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				grid[i][j] = input[j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (canMove(i, j)) {
					dfs(i, j);
					count[0]++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				isVisited[i][j] = false;
				if(grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (canMove(i, j)) {
					dfs(i, j);
					count[1]++;
				}
			}
		}

		System.out.println(count[0] + " " + count[1]);

		br.close();
	}

	private static void dfs(int x, int y) {
		isVisited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (canMove(nx, ny) && isSameColor(x, y, i)) {
				dfs(nx, ny);
			}
		}
	}

	private static boolean canMove(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N && !isVisited[x][y];
	}

	private static boolean isSameColor(int x, int y, int i) {
		return grid[x][y] == grid[x + dx[i]][y + dy[i]];
	}
}