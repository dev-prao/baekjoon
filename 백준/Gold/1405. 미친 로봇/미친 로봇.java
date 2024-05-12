import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, size;
	static double complex;
	static boolean[][] isVisited;

	static double[] moveProbability = new double[4];
	static int[] dr = {0, 0, 1, -1};
	static int[] dc = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			moveProbability[i] = Double.parseDouble(st.nextToken()) / 100;
		}

		size = N * 2 + 1;
		isVisited = new boolean[size][size];
		isVisited[N][N] = true;
		move(N, N, 1, 0);
		System.out.println(1 - complex);
	}

	private static void move(int r, int c, double percent, int depth) {
		if (depth == N) {
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			double np = percent * moveProbability[d];
			if (isOutOfMap(nr, nc)) continue;

			if (isVisited[nr][nc]) {
				complex += np;
				continue;
			}

			isVisited[nr][nc] = true;
			move(nr, nc, np, depth + 1);
			isVisited[nr][nc] = false;
		}

	}

	private static boolean isOutOfMap(int r, int c) {
		return r < 0 || c < 0 || r > 2 * N || c > 2 * N;
	}
}
