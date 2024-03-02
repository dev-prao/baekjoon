import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dice; //up, left, front, right, back, down

	static int res = -1;
	static int[] op = {5, 3, 4, 1, 2, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 6; i++) {
			int max = 0;
			for (int j = 0; j < 6; j++) {
				if (j == i || j == op[i]) continue;
				max = Math.max(max, dice[0][j]);
			}
			dfs(dice[0][i], max, 1);
		}

		System.out.println(res);
	}

	static void dfs(int top, int sum, int depth) {
		if (depth == N) {
			res = Math.max(res, sum);
			return;
		}

		int nTop = -1;
		int max = -1;
		for (int i = 0; i < 6; i++) {
			if (dice[depth][i] == top) {
				nTop = op[i];
				break;
			}
		}

		for (int i = 0; i < 6; i++) {
			if (i == nTop || i == op[nTop]) continue;
			max = Math.max(max, dice[depth][i]);
		}

		dfs(dice[depth][nTop], sum + max, depth + 1);
	}
}
