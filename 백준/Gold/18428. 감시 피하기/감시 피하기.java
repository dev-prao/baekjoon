import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean answer;

	static char[][] arr;

	static List<int[]> teacher = new ArrayList<>();
	static List<int[]> space = new ArrayList<>();

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = st.nextToken().charAt(0);
				if (arr[i][j] == 'X') space.add(new int[] {i, j});
				if (arr[i][j] == 'T') teacher.add(new int[] {i, j});
			}
		}
		combination(0, new int[] {-1, -1, -1}, -1);

		if (answer) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}

	static void combination(int depth, int[] arr, int idx) {
		if (depth == 3) {
			check(arr);
			return;
		}
		if (answer) return;

		for (int i = idx + 1; i < space.size(); i++) {
			arr[depth] = i;
			combination(depth + 1, arr, i);
		}
	}

	static void check(int[] tmp) {
		boolean[][] visit = new boolean[N][N];

		for (int i = 0; i < 3; i++) {
			visit[space.get(tmp[i])[0]][space.get(tmp[i])[1]] = true;
		}

		for (int[] cur : teacher) {

			for (int j = 0; j < 4; j++) {
				int nr = cur[0] + dr[j];
				int nc = cur[1] + dc[j];

				while (nr < N && nr >= 0 && nc < N && nc >= 0 && !visit[nr][nc]) {
					if (arr[nr][nc] == 'S') return;
					nr += dr[j];
					nc += dc[j];
				}
			}
		}
		answer = true;
	}
}
