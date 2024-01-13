import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph;
	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		dfs(1, -1, 0);
		if (sum % 2 == 0) {
			bw.write("No");
		}
		if (sum % 2 == 1) {
			bw.write("Yes");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int value, int parent, int depth) {
		if (graph.get(value).size() == 1 && graph.get(value).get(0) == parent) {
			sum += depth;
			return;
		}
		for (int node : graph.get(value)) {
			if (node != parent) {
				dfs(node, value, depth + 1);
			}
		}
	}
}
