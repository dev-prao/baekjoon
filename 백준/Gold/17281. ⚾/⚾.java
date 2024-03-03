import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int ans = -1;
	static boolean[] isSelected = new boolean[10];
	static int[] lineUp = new int[10];
	static int[][] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		result = new int[N][10];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		lineUp[4] = 1;
		isSelected[4] = true;

		permutation(2);
		System.out.println(ans);
	}

	private static void permutation(int idx) {
		if (idx == 10) {
			ans = Math.max(ans, game());
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				lineUp[i] = idx;
				permutation(idx + 1);
				isSelected[i] = false;
			}
		}
	}

	private static int game() {
		int batterIdx = 1;
		int score = 0;
		for (int i = 0; i < N; i++) {
			//아웃, 1루, 2루, 3루, 홈
			int[] base = {0, 0, 0, 0, 0};
			while (base[0] < 3) {
				hit(base, result[i][lineUp[batterIdx]]);
				if (batterIdx == 9) {
					batterIdx = 1;
				} else {
					batterIdx++;
				}
			}
			score += base[4];
		}
		return score;
	}

	private static void hit(int[] base, int n) {
		for (int inning = 0; inning < n; inning++) {
			base[4] += base[3];
			base[3] = base[2];
			base[2] = base[1];
			base[1] = 0;
		}
		//베이스 이동 완료 후 입력받은 베이스 값 증가
		base[n]++;
	}
}