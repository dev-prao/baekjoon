import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Point {
		int r, c;

		public Point(final int r, final int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static final char[][] map = new char[5][5];
	private static final boolean[][] visited = new boolean[5][5];
	private static final int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 지도 입력
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// DFS로 7개의 자리 선택하여 이다솜파인지 확인
		dfs(0, 0);
		System.out.println(cnt); // 이다솜파인 경우의 수 출력
	}

	// DFS를 이용하여 7개의 자리 선택
	private static void dfs(int depth, int start) {
		if (depth == 7) {
			// 7개의 자리가 선택되었을 때, 이다솜파인지 확인하고 카운트
			if (checkParty()) cnt++;
		} else {
			// 25개의 자리 중에서 7개 선택
			for (int i = start; i < 25; i++) {
				visited[i / 5][i % 5] = true;
				dfs(depth + 1, i + 1);
				visited[i / 5][i % 5] = false;
			}
		}
	}

	// 선택된 7개의 자리가 이다솜파인지 확인
	private static boolean checkParty() {
		// 방문 여부를 복사한 배열 생성
		boolean[][] copy = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			copy[i] = visited[i].clone();
		}

		int r = 0, c = 0;
		// 선택된 7개의 자리 중 한 자리 찾기
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (copy[i][j]) {
					r = i;
					c = j;
				}
			}
		}

		// BFS로 연속된 7개의 자리 확인
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));

		int connectedCount = 0;
		int dasomParty = 0;
		while (!q.isEmpty()) {
			Point curr = q.poll();

			// 상하좌우 이동하면서 연속된 자리 확인
			for (int[] dir : delta) {
				int nr = curr.r + dir[0];
				int nc = curr.c + dir[1];
				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
				if (copy[nr][nc]) {
					if (map[nr][nc] == 'S') dasomParty++; // 이다솜파인 경우
					connectedCount++; // 연결된 사람 수 증가
					q.add(new Point(nr, nc));
					copy[nr][nc] = false; // 방문 처리
				}
			}
		}
		// 7개가 연속으로 이어져 있는지, 이다솜파가 4명(과반수 이상인지) 확인
		if (connectedCount == 7 && 4 <= dasomParty) return true;
		return false;
	}
}
