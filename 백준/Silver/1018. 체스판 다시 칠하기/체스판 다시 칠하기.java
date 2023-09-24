import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static boolean[][] chess;
	public static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		chess = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			String chessRow = br.readLine();
			for (int j = 0; j < col; j++) {
				if (chessRow.charAt(j) == 'W') {
					chess[i][j] = true;
				}
				if (chessRow.charAt(j) == 'B') {
					chess[i][j] = false;
				}
			}
		}

		int rangeOfRow = row - 7;
		int rangeOfCol = col - 7;

		for (int i = 0; i < rangeOfRow; i++) {
			for (int j = 0; j < rangeOfCol; j++) {
				find(i, j);
			}
		}
		System.out.println(min);
	}

	public static void find(int x, int y) {
		int endX = x + 8;
		int endY = y + 8;
		int count = 0;

		boolean TF = chess[x][y];

		for (int i = x; i < endX; i++) {
			for (int j = y; j < endY; j++) {

				if (chess[i][j] != TF) {
					count++;
				}

				TF = !TF;
			}

			TF = !TF;
		}

		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}
}
