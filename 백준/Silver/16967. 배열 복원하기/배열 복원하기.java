import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int H, W, X, Y;
	static int[][] A;
	static int[][] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		A = new int[H][W];
		B = new int[H + X][W + Y];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < X; r++) {
			for (int c = 0; c < W; c++) {
				A[r][c] = B[r][c];
			}
		}

		for (int c = 0; c < Y; c++) {
			for (int r = 0; r < H; r++) {
				A[r][c] = B[r][c];
			}
		}

		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				A[i][j] = B[i][j] - A[i-X][j-Y];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
