import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, R;
	static int level;
	static int[][] map;

	static int[] dr = {0, 1, 0, -1}; //우,하,좌,상
	static int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		level = Math.min(N, M);
		while (R-- > 0) rotate();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void rotate() {
		for (int layer = 0; layer < level / 2; layer++) {
			int r = layer;
			int c = layer;

			int tmp = map[r][c];

			int idx = 0;
			while (idx < 4) {
				int nr = r + dr[idx];
				int nc = c + dc[idx];
				if (nr < N - layer && nc < M - layer && nr >= layer && nc >= layer) {
					map[r][c] = map[nr][nc];
					r = nr;
					c = nc;
					continue;
				}
				idx++;
			}
			map[layer + 1][layer] = tmp;
		}
	}
}
