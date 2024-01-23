import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] dice = new int[6];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] dy = {0, 0, 0, -1, 1};
		int[] dx = {0, 1, -1, 0, 0};

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int command = Integer.parseInt(st.nextToken());

			int ny = y + dy[command];
			int nx = x + dx[command];

			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue;

			y = ny;
			x = nx;

			roll(command);

			if (map[y][x] == 0) {
				map[y][x] = dice[1];
				sb.append(dice[0]).append("\n");
			} else {
				dice[1] = map[y][x];
				map[y][x] = 0;
				sb.append(dice[0]).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void roll(int command) {
		switch (command) {
			case 1:
				east();
				break;
			case 2:
				west();
				break;
			case 3:
				north();
				break;
			default:
				south();
				break;
		}
	}

	private static void east() {
		int top = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = top;
	}

	private static void west() {
		int top = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = top;
	}

	private static void south() {
		int top = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = top;
	}

	private static void north() {
		int top = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = top;
	}
}