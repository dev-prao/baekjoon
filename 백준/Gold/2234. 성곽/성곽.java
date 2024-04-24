import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	private static final Map<Integer, Integer> AREAS = new HashMap<>();
	private static final int[][] DELTAS = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
	private static final int EMPTY = 0;

	private static int[][] castle;
	private static int[][] rooms;
	private static int n, m, room, maxArea, maxAreaWithDelete;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		castle = new int[m][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rooms = new int[m][n];
		search();
		searchMaxAreaWithDelete();
		sb.append(room).append("\n").append(maxArea).append("\n").append(maxAreaWithDelete);
		System.out.println(sb);
	}

	private static void search() {
		Deque<int[]> q = new ArrayDeque<>();
		boolean[][] isVisited = new boolean[m][n];
		int roomNumber = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisited[i][j]) {
					room++;
					q.offer(new int[]{i, j});
					isVisited[i][j] = true;
					rooms[i][j] = roomNumber;
					int area = 1;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						for (int d = 0, deltasLength = DELTAS.length; d < deltasLength; d++) {
							if ((castle[r][c] & (1 << d)) == EMPTY) {
								int nr = r + DELTAS[d][0];
								int nc = c + DELTAS[d][1];
								if (nr >= 0 && nr < m && nc >= 0 && nc < n && !isVisited[nr][nc]) {
									q.offer(new int[]{nr, nc});
									isVisited[nr][nc] = true;
									rooms[nr][nc] = roomNumber;
									area++;
								}
							}
						}
					}
					AREAS.put(roomNumber++, area);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
	}

	private static void searchMaxAreaWithDelete() {
		boolean[][] isVisited = new boolean[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				for (int[] delta : DELTAS) {
					int nr = r + delta[0];
					int nc = c + delta[1];
					if (nr >= 0 && nr < m && nc >= 0 && nc < n && rooms[r][c] != rooms[nr][nc] && !isVisited[nr][nc]) {
						maxAreaWithDelete = Math.max(maxAreaWithDelete, AREAS.get(rooms[r][c]) + AREAS.get(rooms[nr][nc]));
						isVisited[nr][nc] = true;
					}
				}
			}
		}
	}
}
