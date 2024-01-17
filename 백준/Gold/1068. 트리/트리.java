import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static boolean[] isVisited;
	static int deletedNode;
	static int root;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		isVisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			if (node == -1) {
				root = i;
				continue;
			}
			graph[node].add(i);
		}
		deletedNode = Integer.parseInt(br.readLine());
		dfs(root);
		System.out.println(count);
		br.close();
	}

	private static void dfs(int node) {
		if (node == deletedNode) {
			return;
		}
		isVisited[node] = true;

		if (graph[node].isEmpty()) {
			count++;
		}

		for (int child : graph[node]) {
			if (graph[node].size() == 1 && child == deletedNode) {
				count++;
			}
			if (!isVisited[child]) {
				dfs(child);
			}
		}
	}
}