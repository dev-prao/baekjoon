import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[] jihun;
	static char[][] maze;
	static boolean[][] visit;

	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열

		maze = new char[R][C];
		visit = new boolean[R][C];
		Deque<int[]> move = new ArrayDeque<>();
		Deque<int[]> fires = new ArrayDeque<>();

		//#:벽, .:지나갈 수 있는 공간, J:지훈이의 미로에서 초기 위치(지나갈 수 있음), F:불이 난 공간
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				maze[i][j] = input.charAt(j);

				if (maze[i][j] == 'J') {
					jihun = new int[]{i, j};
					move.offer(new int[]{i, j});
					visit[i][j] = true;
				} else if (maze[i][j] == 'F') {
					fires.offer(new int[]{i, j});
				}
			}
		}

		int time = 0;

		while (!move.isEmpty()) {
			time++;

			// 불을 먼저 확산시킵니다.
			int fireSize = fires.size();
			for (int i = 0; i < fireSize; i++) {
				int[] curFire = fires.poll();
				for (int d = 0; d < 4; d++) {
					int nr = curFire[0] + dr[d];
					int nc = curFire[1] + dc[d];
					if (isInValid(nr, nc) || maze[nr][nc] == '#' || maze[nr][nc] == 'F') continue;
					maze[nr][nc] = 'F';
					fires.offer(new int[]{nr, nc});
				}
			}

			// 지훈이의 이동을 처리합니다.
			int moveSize = move.size();
			for (int i = 0; i < moveSize; i++) {
				int[] cur = move.poll();
				for (int d = 0; d < 4; d++) {
					int nr = cur[0] + dr[d];
					int nc = cur[1] + dc[d];
					if (isInValid(nr, nc)) {
						System.out.println(time);
						return;
					}
					if (visit[nr][nc] || maze[nr][nc] == '#' || maze[nr][nc] == 'F') continue;
					visit[nr][nc] = true;
					move.offer(new int[]{nr, nc});
				}
			}
		}

		System.out.println("IMPOSSIBLE");
	}

	public static boolean isInValid(int r, int c) {
		return r < 0 || c < 0 || r >= R || c >= C;
	}
}
