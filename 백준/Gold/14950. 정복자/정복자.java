import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

		@Override
		public String toString() {
			return "Edge{" +
				"start=" + start +
				", end=" + end +
				", weight=" + weight +
				'}';
		}
	}

	static int N, M, T;
	static int start, end, weight;
	static int count, cost;
	static List<Edge> edges;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//모든 도시의 쌍에는 그 도시를 연결하는 도로로 구성된 경로 존재
		//도로는 양방향 도로, 각 도로는 사용하는데 비용 존재
		//각각 도시는 1번부터 N번까지 번호 붙여짐
		//라운드마다 비용 t만큼 증가
		//한번 정복한 도시 다시 정복 x
		//도시 정복 - 유니온 파인드
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		parents = new int[N];
		edges = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			make(i);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken()) - 1;
			end = Integer.parseInt(st.nextToken()) - 1;
			weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(start, end, weight));
		}

		Collections.sort(edges);

		for (Edge edge : edges) {
			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				cost += edge.weight + T * count;
				count++;
			}
			if (count == M) {
				break;
			}
		}
		System.out.println(cost);
	}

	static void make(int idx) {
		parents[idx] = idx;
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
