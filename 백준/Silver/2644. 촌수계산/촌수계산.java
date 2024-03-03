import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int res = -1;
	static int A, B; //촌수 계산할 사람
	static List<Integer>[] graph;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			graph[parent].add(child);
			graph[child].add(parent);
		}

		dfs(A, 0);
		System.out.println(res);
	}

	static void dfs(int node, int depth) {
		if (node == B) {
			res = depth;
			return;
		}

		for (int next : graph[node]) {
			if (visit[next]) continue;
			visit[next] = true;
			dfs(next, depth + 1);
			visit[next] = false;
		}
	}
}
