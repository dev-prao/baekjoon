import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] visit;
	static List<Integer>[] graph;
	static int index;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		bw.write(String.valueOf(index));
		bw.close();
		br.close();
	}

	static void bfs(int node) {
		if (visit[node])
			return;
		index++;
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(node);
		visit[node] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int next : graph[curr]) {
				if (visit[next])
					continue;
				visit[next] = true;
				q.offer(next);
			}
		}
	}
}
