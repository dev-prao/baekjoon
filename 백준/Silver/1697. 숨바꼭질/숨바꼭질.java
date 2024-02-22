import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];

		bw.write(String.valueOf(bfs()));
		bw.close();
		br.close();
	}

	static int bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {N, 0});
		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (visit[curr[0]]) {
				continue;
			}

			visit[curr[0]] = true;

			if (curr[0] == K) {
				return curr[1];
			}
			if (curr[0] - 1 >= 0 && !visit[curr[0] - 1]) {
				q.offer(new int[] {curr[0] - 1, curr[1] + 1});
			}
			if (curr[0] + 1 <= 100_000 && !visit[curr[0] + 1]) {
				q.offer(new int[] {curr[0] + 1, curr[1] + 1});
			}
			if (curr[0] * 2 <= 100_000 && !visit[curr[0] * 2]) {
				q.offer(new int[] {curr[0] * 2, curr[1] + 1});
			}
		}
		return -1;
	}
}
