import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return this.weight - o.weight;
		}

	}

	static int V, E;
	static int start, end, weight;
	static int[] parent;
	static Edge[] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parent = new int[V];
		
		for (int idx = 0; idx < V; idx++) {
			make(idx);
		}
		
		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, weight);
		}
		Arrays.sort(edges);
		
		int cnt = 0;
		int ans = 0;
		for(Edge e : edges) {
			int ps = find(e.start);
			int pe = find(e.end);
			if(ps != pe) {
				union(ps, pe);
				ans += e.weight;
				cnt++;
			}
			if(cnt == V -1) break;
		}
		
		System.out.println(ans);
	}

	static void make(int idx) {
		parent[idx] = idx;
	}
	
	static int find(int idx) {
		if(parent[idx] != idx) return parent[idx] = find(parent[idx]);
		return idx;
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa < pb) {
			parent[pb] = pa;
			return;
		}
		parent[pa] = pb;
	}
}