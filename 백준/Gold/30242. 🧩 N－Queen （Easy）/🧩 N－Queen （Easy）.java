import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 첫 번째 줄에서 정수 N을 입력 받음
		int[] board = new int[N]; // 크기가 N인 배열 생성
		StringTokenizer st = new StringTokenizer(br.readLine()); // 두 번째 줄을 공백을 기준으로 분리
		for (int i = 0; i < N; i++) {
			board[i] = Integer.parseInt(st.nextToken()) - 1; // 배열에 값을 저장할 때 1을 뺌
		}

		if (!nQueen(board)) { // 퀸을 배치하는 함수 호출하여 결과 확인
			System.out.println(-1); // 퀸을 배치할 수 없는 경우 -1 출력
		}
	}

	// 퀸을 배치하는 함수
	static boolean nQueen(int[] board) {
		boolean skip;
		for (int row = 0; row < N; row++) { // 보드의 각 행에 대해 반복
			// 이미 퀸이 놓여있다면 건너뜀
			if (board[row] != -1) continue;
			for (int col = 0; col < N; col++) { // 해당 행의 각 열에 대해 반복
				skip = false;
				for (int r = 0; r < N; r++) {
					// 다른 퀸과 같은 열에 있거나 대각선 방향에 있는지 확인
					if (board[r] == col || (board[r] != -1 && (board[r] == col + r - row
						|| board[r] == col - r + row))) {
						skip = true; // 퀸을 놓을 수 없음
						break;
					}
				}
				if (skip) {
					continue; // 다음 열로 이동
				}
				board[row] = col; // 퀸을 현재 열에 놓음
				if (nQueen(board)) { // 재귀적으로 다음 행에 퀸을 놓음
					return true; // 퀸을 모두 놓았으면 true 반환
				}
				board[row] = -1; // 퀸을 놓을 수 없으면 이전 상태로 되돌림 (백트래킹)
			}
			return false; // 해당 행에는 퀸을 놓을 수 없음
		}
		printBoard(board); // 보드에 퀸을 모두 놓은 경우 보드 출력
		return true; // 퀸을 모두 놓았음을 반환
	}

	// 보드 출력 함수
	static void printBoard(int[] board) {
		for (int i : board) {
			System.out.print((i + 1) + " "); // 퀸이 놓인 열을 출력 (1을 더한 값)
		}
		System.out.println(); // 줄 바꿈
	}
}
