import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, P, C, D, node;
	static boolean[] visit;
	static List<List<Node>> tree;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}
		while (N-- > 1) {
			st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			tree.get(P).add(new Node(C, D));
			tree.get(C).add(new Node(P, D));
		}
		visit = new boolean[10001];
		dfs(1, 0);
		visit = new boolean[10001];
		dfs(node, 0);
		bw.write(String.valueOf(max));
		bw.close();
		br.close();
	}

	static void dfs(int idx, int dist) {
		if (dist > max) {
			node = idx;
			max = dist;
		}
		visit[idx] = true;

		for (Node next : tree.get(idx)) {
			if (!visit[next.data]) {
				dfs(next.data, dist + next.dist);
				visit[next.data] = true;
			}
		}
	}

	static class Node {
		int data;
		int dist;

		public Node(final int data, final int dist) {
			this.data = data;
			this.dist = dist;
		}
	}
}
