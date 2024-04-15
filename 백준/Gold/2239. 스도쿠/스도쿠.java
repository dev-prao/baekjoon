import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] board = new int[9][9];
	static boolean[][] fixed = new boolean[9][9];
	static boolean[][] rowCheck = new boolean[9][10];
	static boolean[][] colCheck = new boolean[9][10];
	static boolean[][][] blockCheck = new boolean[3][3][10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int r = 0; r < 9; r++) {
			String s = br.readLine();

			for (int c = 0; c < 9; c++) {
				int curNum = s.charAt(c) - '0';

				if (curNum > 0) {
					board[r][c] = curNum;
					fixed[r][c] = true;
					rowCheck[r][curNum] = true;
					colCheck[c][curNum] = true;
					blockCheck[r / 3][c / 3][curNum] = true;
				}
			}
		}

		recur(0);

		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				sb.append(board[r][c]);
			}
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	static boolean recur(int depth) {
		if (depth == 81) {
			return true;
		}

		int r = depth / 9;
		int c = depth % 9;

		if (fixed[r][c]) {
			if (recur(depth + 1)) {
				return true;
			}

			return false;
		}

		for (int curNum = 1; curNum <= 9; curNum++) {
			if (rowCheck[r][curNum] || colCheck[c][curNum] || blockCheck[r / 3][c / 3][curNum]) {
				continue;
			}

			rowCheck[r][curNum] = true;
			colCheck[c][curNum] = true;
			blockCheck[r / 3][c / 3][curNum] = true;
			board[r][c] = curNum;

			if (recur(depth + 1)) {
				return true;
			}

			rowCheck[r][curNum] = false;
			colCheck[c][curNum] = false;
			blockCheck[r / 3][c / 3][curNum] = false;
		}

		return false;
	}

}