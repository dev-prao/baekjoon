import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static int[] board;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N];

		nQueen(0);
		System.out.println(count);
	}

	public static void nQueen(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			board[depth] = i;
			if (check(depth)) {
				nQueen(depth + 1);
			}
		}

	}

	public static boolean check(int col) {

		for (int i = 0; i < col; i++) {
			if (board[col] == board[i]) {
				return false;
			}
			else if (Math.abs(col - i) == Math.abs(board[col] - board[i])) {
				return false;
			}
		}

		return true;
	}
}