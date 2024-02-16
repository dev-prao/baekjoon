import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, M, day;
	static int[][] map;

	static Deque<Tomato> queue = new ArrayDeque<>();

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					queue.add(new Tomato(r, c, 0));
				}
			}
		}
		if(checkState()) {
			bw.write("0");
			bw.close();
			br.close();
			return;
		}
		
		int day = 0;

		while (!queue.isEmpty()) {
			Tomato curr = queue.poll();
			day = curr.day;
			
			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 0)
					continue;

				map[nx][ny] = 1;
				queue.add(new Tomato(nx, ny, day + 1));
			}
		}
		
		if(checkState()) {
			bw.write(String.valueOf(day));
		} else {
			bw.write("-1");
		}
		bw.close();
		br.close();
	}
	
	private static boolean checkState() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 0) return false;
			}
		}
		return true;
	}

	static class Tomato {
		int x;
		int y;
		int day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}
}
