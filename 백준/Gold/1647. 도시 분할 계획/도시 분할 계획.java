import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(final int start, final int end, final int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(final Edge o) {
			return weight - o.weight;
		}
	}

	static int N, M;
	static int start, end, weight;
	static int count, cost;
	static List<Edge> edges;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N];
		edges = new ArrayList<>();

		//make-set
		make();

		//input
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(start, end, weight));
		}

		//sort
		Collections.sort(edges);

		int max = 0;
		for (Edge edge : edges) {
			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				cost += edge.weight;
				max = Math.max(edge.weight, max);
				count++;
			}

			if(count == M) break;
		}

		System.out.println(cost - max);
	}

	static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if(parents[a] != a) return parents[a] = find(parents[a]);
		return parents[a];
	}

	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
			return;
		}
		parents[aRoot] = bRoot;
	}
}
