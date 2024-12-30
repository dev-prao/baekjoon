import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N: 유저의 수, M: 관계의 수
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] relation = new int[N + 1][N + 1]; // 관계 저장 배열

		// 관계 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			relation[p1][p2] = 1;
			relation[p2][p1] = 1;
		}

		int minKevinBacon = Integer.MAX_VALUE; // 최소 케빈 베이컨 값
		int result = 0; // 최소값을 가진 사람 번호

		// 각 사람마다 BFS 실행
		for (int i = 1; i <= N; i++) {
			int kevinBacon = bfs(i, N, relation); // i번째 사람의 케빈 베이컨 값 계산
			if (kevinBacon < minKevinBacon) {
				minKevinBacon = kevinBacon;
				result = i; // 최소값 갱신
			}
		}

		// 결과 출력
		System.out.println(result);
	}

	// BFS를 통해 케빈 베이컨 값 계산
	static int bfs(int start, int N, int[][] relation) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int[] distance = new int[N + 1]; // 거리 배열

		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next = 1; next <= N; next++) {
				if (relation[current][next] == 1 && !visited[next]) { // 연결된 노드 && 미방문
					visited[next] = true;
					distance[next] = distance[current] + 1; // 거리 갱신
					queue.offer(next);
				}
			}
		}

		// 거리의 총합 계산 (케빈 베이컨 수)
		int totalDistance = 0;
		for (int i = 1; i <= N; i++) {
			totalDistance += distance[i];
		}

		return totalDistance;
	}
}
