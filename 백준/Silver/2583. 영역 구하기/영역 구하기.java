import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int M, N, K, areaNum;
	static int[][] map;

	static List<Integer> area = new ArrayList<>();

	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken()); //열
		N = Integer.parseInt(st.nextToken()); //행
		K = Integer.parseInt(st.nextToken()); //직사각형 개수

		map = new int[N][M];

		//fill square
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			for (int r = sr; r < er; r++) {
				for (int c = sc; c < ec; c++) {
					if (map[r][c] != 0) continue;
					map[r][c] = -1;
				}
			}
		}

		//fill area number
		areaNum = 1;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 0) continue;
				area.add(getAreaSize(r, c));
				areaNum++;
			}
		}

		Collections.sort(area);

		sb.append(areaNum - 1).append("\n");
		for (int size : area) {
			if(size == 0) continue;
			sb.append(size).append(" ");
		}

		System.out.println(sb);
	}

	private static int getAreaSize(final int r, final int c) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r, c});
		map[r][c] = areaNum;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = cur[0] + dr[d];
				int nc = cur[1] + dc[d];
				if (isOutOfMap(nr, nc) || map[nr][nc] != 0) continue;
				map[nr][nc] = areaNum;
				q.offer(new int[] {nr, nc});
				cnt++;
			}
		}

		return cnt;
	}

	private static boolean isOutOfMap(final int r, final int c) {
		return r < 0 || c < 0 || r >= N || c >= M;
	}
}
