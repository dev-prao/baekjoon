import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int count = 0;
	static int[] parents;
	static List<Integer>[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		tree = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		dfs(1);
		for (int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void dfs(int node) {
		if (count == N) {
			return;
		}

		for (int next : tree[node]) {
			if (parents[next] == 0) {
				parents[next] = node;
				count++;
				dfs(next);
			}
		}
	}
}
