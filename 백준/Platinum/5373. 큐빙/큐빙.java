import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static char[][] U, D, F, B, L, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int testCount = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testCount; test++) {
			int n = Integer.parseInt(br.readLine());
			String[] data = br.readLine().split(" ");
			U = new char[][] {{'w', 'w', 'w'}, {'w', 'w', 'w'}, {'w', 'w', 'w'}};
			D = new char[][] {{'y', 'y', 'y'}, {'y', 'y', 'y'}, {'y', 'y', 'y'}};
			F = new char[][] {{'r', 'r', 'r'}, {'r', 'r', 'r'}, {'r', 'r', 'r'}};
			B = new char[][] {{'o', 'o', 'o'}, {'o', 'o', 'o'}, {'o', 'o', 'o'}};
			L = new char[][] {{'g', 'g', 'g'}, {'g', 'g', 'g'}, {'g', 'g', 'g'}};
			R = new char[][] {{'b', 'b', 'b'}, {'b', 'b', 'b'}, {'b', 'b', 'b'}};

			for (int i = 0; i < n; i++) {
				String str = data[i];
				char move = str.charAt(0);
				char dir = str.charAt(1);
				if (move == 'U') {
					rotate_U(dir);
				} else if (move == 'D') {
					rotate_D(dir);
				} else if (move == 'F') {
					rotate_F(dir);
				} else if (move == 'B') {
					rotate_B(dir);
				} else if (move == 'L') {
					rotate_L(dir);
				} else if (move == 'R') {
					rotate_R(dir);
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(U[i][j]);
				}
				sb.append("\n");
			}
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	public static void rotate_U(char dir) {
		if (dir == '+') {
			U = rotateClock(U);
			// 뒷 - 오 - 앞 - 왼 - 뒷
			char[] temp = B[0];
			B[0] = L[0];
			L[0] = F[0];
			F[0] = R[0];
			R[0] = temp;
		} else {
			U = rotateReverseClock(U);
			// 뒷 - 왼 - 앞 - 오 - 뒷 
			char[] temp = B[0].clone();
			B[0] = R[0].clone();
			R[0] = F[0].clone();
			F[0] = L[0].clone();
			L[0] = temp;
		}
	}

	public static void rotate_D(char dir) {
		if (dir == '+') {
			D = rotateClock(D);
			// 뒷 - 왼 - 앞 - 오 - 뒷
			char[] temp = B[2].clone();
			B[2] = R[2].clone();
			R[2] = F[2].clone();
			F[2] = L[2].clone();
			L[2] = temp;
		} else {
			D = rotateReverseClock(D);
			// 뒷 - 오 - 앞 - 왼 - 뒷
			char[] temp = B[2].clone();
			B[2] = L[2].clone();
			L[2] = F[2].clone();
			F[2] = R[2].clone();
			R[2] = temp;
		}
	}

	public static void rotate_F(char dir) {
		if (dir == '+') {
			F = rotateClock(F);
			// 윗 - 오 - 바 - 왼 - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[2][i];
			}

			for (int i = 0; i < 3; i++) {
				U[2][i] = L[2 - i][2];
			}

			for (int i = 0; i < 3; i++) {
				L[i][2] = D[2][2 - i];
			}

			for (int i = 0; i < 3; i++) {
				D[2][i] = R[i][0];
			}

			for (int i = 0; i < 3; i++) {
				R[i][0] = temp[i];
			}

		} else {
			F = rotateReverseClock(F);
			// 윗 - 왼 - 바 - 오 - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[2][2 - i];
			}

			for (int i = 0; i < 3; i++) {
				U[2][i] = R[i][0];
			}

			for (int i = 0; i < 3; i++) {
				R[i][0] = D[2][i];
			}

			for (int i = 0; i < 3; i++) {
				D[2][i] = L[2 - i][2];
			}

			for (int i = 0; i < 3; i++) {
				L[i][2] = temp[i];
			}

		}
	}

	public static void rotate_B(char dir) {
		if (dir == '+') {
			B = rotateClock(B);
			// 윗 - 왼 - 바 - 오 - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[0][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				U[0][i] = R[i][2];
			}
			for (int i = 0; i < 3; i++) {
				R[i][2] = D[0][i];
			}
			for (int i = 0; i < 3; i++) {
				D[0][i] = L[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				L[i][0] = temp[i];
			}

		} else {
			B = rotateReverseClock(B);
			// 윗 - 오 - 바 - 왼 - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[0][i];
			}

			for (int i = 0; i < 3; i++) {
				U[0][i] = L[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				L[i][0] = D[0][2 - i];
			}
			for (int i = 0; i < 3; i++) {
				D[0][i] = R[i][2];
			}
			for (int i = 0; i < 3; i++) {
				R[i][2] = temp[i];
			}
		}
	}

	public static void rotate_L(char dir) {
		if (dir == '+') {
			L = rotateClock(L);
			// 윗 - 앞 - 바 - 뒷 - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[i][0];
			}
			for (int i = 0; i < 3; i++) {
				U[i][0] = B[2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				B[i][2] = D[i][2];
			}
			for (int i = 0; i < 3; i++) {
				D[i][2] = F[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				F[i][0] = temp[i];
			}
		} else {
			L = rotateReverseClock(L);
			// 윗 - 뒷 - 바 - 앞  - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				U[i][0] = F[i][0];
			}
			for (int i = 0; i < 3; i++) {
				F[i][0] = D[2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				D[i][2] = B[i][2];
			}
			for (int i = 0; i < 3; i++) {
				B[i][2] = temp[i];
			}
		}
	}

	public static void rotate_R(char dir) {
		if (dir == '+') {
			R = rotateClock(R);
			// 윗 - 뒷 - 바 - 앞  - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				U[i][2] = F[i][2];
			}
			for (int i = 0; i < 3; i++) {
				F[i][2] = D[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				D[i][0] = B[i][0];
			}
			for (int i = 0; i < 3; i++) {
				B[i][0] = temp[i];
			}
		} else {
			R = rotateReverseClock(R);
			// 윗 - 앞 - 바 - 뒷 - 윗
			char[] temp = new char[3];
			for (int i = 0; i < 3; i++) {
				temp[i] = U[i][2];
			}
			for (int i = 0; i < 3; i++) {
				U[i][2] = B[2 - i][0];
			}
			for (int i = 0; i < 3; i++) {
				B[i][0] = D[i][0];
			}
			for (int i = 0; i < 3; i++) {
				D[i][0] = F[2 - i][2];
			}
			for (int i = 0; i < 3; i++) {
				F[i][2] = temp[i];
			}
		}
	}

	// 시계방향 90도 회전
	public static char[][] rotateClock(char[][] arr) {
		char[][] rotate = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = arr[2 - j][i];
			}
		}

		return rotate;
	}

	// 반시계방향 90도 회전
	public static char[][] rotateReverseClock(char[][] arr) {
		char[][] rotate = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rotate[i][j] = arr[j][2 - i];
			}
		}
		return rotate;
	}
}
