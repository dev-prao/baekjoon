import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] belt;
	static boolean[] hasRobot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		belt = new int[2 * N];
		hasRobot = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(String.valueOf(rotate()));
		bw.close();
	}

	private static int rotate() {
		int count = 0;
		while (isValid()) {
			// 1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
			int temp = belt[belt.length - 1];
			for (int i = belt.length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = temp;

			for (int i = hasRobot.length - 1; i > 0; i--) {
				hasRobot[i] = hasRobot[i - 1];
			}
			hasRobot[0] = false;
			hasRobot[N - 1] = false;

			//2.가장 먼저 벨트에 올라간 로봇부터 벨트가 회전하는 방향으로 한칸 이동한다.
			for (int i = hasRobot.length - 1; i > 0; i--) {
				if (hasRobot[i - 1] && !hasRobot[i] && belt[i] >= 1) {
					belt[i]--;
					hasRobot[i] = true;
					hasRobot[i - 1] = false;
				}
			}

			//3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇 올린다.
			if (belt[0] > 0) {
				hasRobot[0] = true;
				belt[0]--;
			}
			count++;
		}
		return count;
	}

	private static boolean isValid() {
		int count = 0;
		for (int i = 0; i < belt.length; i++) {
			if (belt[i] == 0) {
				count++;
			}
			if (count >= K)
				return false;
		}
		return true;
	}

}
