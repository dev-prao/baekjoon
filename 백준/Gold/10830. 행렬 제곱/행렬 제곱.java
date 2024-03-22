import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private final static int MOD = 1000;
	public static int N;
	public static int[][] target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		target = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				target[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		int[][] result = pow(target, B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static int[][] pow(int[][] matrix, long exp) {
		if (exp == 1L) {
			return matrix;
		}
		int[][] result = pow(matrix, exp / 2);

		result = multiply(result, result);

		if (exp % 2 == 1L) {
			result = multiply(result, matrix);
		}

		return result;
	}

	public static int[][] multiply(int[][] m1, int[][] m2) {

		int[][] ret = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {

					ret[i][j] += m1[i][k] * m2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		return ret;
	}
}

