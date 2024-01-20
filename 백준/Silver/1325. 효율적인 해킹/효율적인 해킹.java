import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] relation = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			relation[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			relation[B].add(A);
		}

		int max = Integer.MIN_VALUE;
		int[] answer = new int[N + 1];
		boolean[][] visit = new boolean[N + 1][N + 1];
		Queue<Integer> bfs = new ArrayDeque<>();

		for (int i = 1; i < N + 1; i++) {
			bfs.offer(i);

			while (!bfs.isEmpty()) {
				int target = bfs.poll();
				if (visit[i][target]) {
					continue;
				}
				visit[i][target] = true;
				answer[i]++;

				for (int j = 0; j < relation[target].size(); j++) {
					if (visit[i][relation[target].get(j)]) {
						continue;
					}
					if (relation[target].get(j) < i) { //탐색이 완료된 경우
						for (int k = 1; k <= N; k++) {
							if (visit[i][k]) {
								continue;
							}
							if (visit[relation[target].get(j)][k]) {
								visit[i][k] = true;
								answer[i]++;
							}
						}
					} else {
						bfs.offer(relation[target].get(j));
					}
				}
			}
			max = Math.max(answer[i], max);
		}

		for (int i = 1; i < N + 1; i++) {
			if (answer[i] == max) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
