import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int x, cost;

		public Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}

	static int N, K, target;
	static int[] cost, indegree, dp;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cost = new int[N + 1];
			indegree = new int[N + 1];
			dp = new int[N + 1];
			adj = new List[N + 1];
			for (int idx = 1; idx <= N; idx++) adj[idx] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int idx = 1; idx <= N; idx++) cost[idx] = Integer.parseInt(st.nextToken());

			for (int v = 0; v < K; v++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				indegree[b]++;
			}

			target = Integer.parseInt(br.readLine());
			sb.append(bfs()).append("\n");
		}
		System.out.println(sb);

	}

	public static int bfs() {
		Queue<Node> q = new LinkedList<>();
		for (int idx = 1; idx <= N; idx++) {
			if (indegree[idx] == 0) q.offer(new Node(idx, cost[idx]));
		}

		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.x == target) return curr.cost;

			for (int next : adj[curr.x]) {
				indegree[next]--;
				dp[next] = Math.max(dp[next], curr.cost);
				if (indegree[next] == 0) q.offer(new Node(next, dp[next] + cost[next]));
			}

		}
		return -1;
	}

}