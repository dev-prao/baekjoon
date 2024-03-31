import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	static class Cheese {
		int r, c;

		public Cheese(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] visit;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	static Deque<Cheese> q = new ArrayDeque<>();
	static ArrayList<Cheese> meltingCheese = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		//input
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		visit = new boolean[N][M];
		//get map
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(input[j]);
		}

		int time = 0;
		//main logic
		while (true) {
			//init
			meltingCheese.clear();
			//end condition
			if (isEnd()) break;
			//get borderline
			setAirArea(0, 0);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					//get meltingCheese
					if (map[r][c] == 1 && check(r, c)) meltingCheese.add(new Cheese(r, c));
				}
			}
			//melt cheese
			for (Cheese cs : meltingCheese) map[cs.r][cs.c] = 0;
			//init air area
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] == 2) map[r][c] = 0;
				}
			}
			time++;
		}

		System.out.println(time);
	}

	public static boolean isEnd() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) return false;
			}
		}
		return true;
	}

	public static boolean check(int r, int c) {
		int cnt = 0;
		boolean flag = false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isValid(nr, nc) && map[nr][nc] == 2) cnt++;
		}

		if (cnt >= 2) flag = true;
		return flag;
	}

	public static void setAirArea(int r, int c) {
		for (int i = 0; i < N; i++) Arrays.fill(visit[i], false);
		q.add(new Cheese(r, c));
		visit[r][c] = true;
		map[r][c] = 2;
		while (!q.isEmpty()) {
			Cheese cs = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cs.r + dr[d];
				int nc = cs.c + dc[d];
				if (isValid(nr, nc) && !visit[nr][nc] && map[nr][nc] == 0) {
					q.add(new Cheese(nr, nc));
					visit[nr][nc] = true;
					map[nr][nc] = 2;
				}
			}
		}
	}

	public static boolean isValid(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
