import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int result = 0;
	static List<Integer>[] graph;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		isVisited = new boolean[n + 1];

		StringTokenizer st;
		for (int i = 1; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		dfs(1);
		System.out.println("NO CYCLE");
		br.close();
	}

	private static void dfs(int start) {
		if (start == n) {
			return;
		}
		for (int node : graph[start]) {
			if (isVisited[node]) {
				System.out.println("CYCLE");
				System.exit(0);
				return;
			}
			isVisited[node] = true;
			dfs(node);
			isVisited[node] = false;
		}
	}
}
