import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int root;
	static int count;
	static int[] left;
	static int[] right;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB;
			while ((nodeB = Integer.parseInt(st.nextToken())) != -1) {
				graph[nodeA].add(nodeB);
			}
		}
		root = Integer.parseInt(br.readLine());
		br.close();

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		left = new int[n + 1];
		right = new int[n + 1];

		dfs(root, 0);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(i).append(' ').append(left[i]).append(' ').append(right[i]).append('\n');
		}
		System.out.println(sb);
	}

	static void dfs(int current, int parent) {
		left[current] = ++count;
		for (int child : graph[current]) {
			if (child != parent)
				dfs(child, current);
		}
		right[current] = ++count;
	}
}
