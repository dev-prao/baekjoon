import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1, 0, 0, 1}; // 상, 좌, 우, 하
	static int[] dc = {0, -1, 1, 0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] campus = new char[N][M];
		visited = new boolean[N][M]; // 방문 체크 배열
		Point doyeon = new Point(0, 0);

		// 캠퍼스 정보 입력 및 도연 위치 찾기
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				campus[i][j] = input.charAt(j);
				if (campus[i][j] == 'I') {
					doyeon = new Point(i, j); // 도연의 시작 위치
				}
			}
		}

		// DFS 수행
		int result = dfs(doyeon, campus);

		// 출력
		if (result == 0) {
			System.out.println("TT"); // 아무도 만나지 못한 경우
		} else {
			System.out.println(result); // 만난 사람의 수 출력
		}
	}

	static int dfs(Point current, char[][] campus) {
		int count = 0;

		// 현재 위치 방문 처리
		visited[current.x][current.y] = true;

		// 현재 위치가 사람(P)인 경우 카운트 증가
		if (campus[current.x][current.y] == 'P') {
			count++;
		}

		// 4방향 탐색
		for (int d = 0; d < 4; d++) {
			int nr = current.x + dr[d];
			int nc = current.y + dc[d];

			// 범위 체크 및 방문 여부 확인
			if (nr >= 0 && nc >= 0 && nr < campus.length && nc < campus[0].length && !visited[nr][nc]) {
				// 벽(X)이 아닌 경우만 탐색
				if (campus[nr][nc] != 'X') {
					count += dfs(new Point(nr, nc), campus); // 재귀 호출
				}
			}
		}

		return count;
	}
}
