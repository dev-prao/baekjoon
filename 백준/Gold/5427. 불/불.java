import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w, h, count;
	static char[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static Queue<int[]> fire; //불의 위치
	static Queue<int[]> location; //사람의 위치

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int test = 0; test < tc; test++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			fire = new LinkedList<>();
			location = new LinkedList<>();

			map = new char[h][w];
			for (int r = 0; r < h; r++) {
				String input = br.readLine();
				for (int c = 0; c < w; c++) {
					map[r][c] = input.charAt(c);
					if (map[r][c] == '@') {
						location.offer(new int[] { r, c, 0 });
						continue;
					}
					if (map[r][c] == '*') {
						fire.offer(new int[] { r, c });
					}
				}

			}
			count = 0;
			bfs();

			if (count != 0)
				System.out.println(count);
			else
				System.out.println("IMPOSSIBLE"); //사람이 이동하지 않으면 탈출 할 수 없음
		}

	}
	
	static void bfs() {
		while (!location.isEmpty()) {
			//불의 이동
			int fireSize = fire.size();
			for (int idx = 0; idx < fireSize; idx++) {
				int[] cur = fire.poll();
				int r = cur[0];
				int c = cur[1];

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nc < 0 || nr >= h || nc >= w)
						continue;

					if (map[nr][nc] == '.' || map[nr][nc] == '@') {
						map[nr][nc] = '*';
						fire.offer(new int[] { nr, nc });
					}
				}
			}

			//사람 이동
			int locaionSize = location.size();
			for (int idx = 0; idx < locaionSize; idx++) {

				int[] personLocation = location.poll();
				int cr = personLocation[0];
				int cc = personLocation[1];
				int time = personLocation[2] + 1;

				for (int j = 0; j < 4; j++) {
					int nr = cr + dr[j];
					int nc = cc + dc[j];

					if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
						count = time;
						return;
					}

					if (map[nr][nc] == '.') {
						map[nr][nc] = '@';
						location.offer(new int[] { nr, nc, time });
					}
				}
			}
		}
	}
}