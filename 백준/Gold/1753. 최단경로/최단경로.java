import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end, cost;

	public Node(int end, int weight) {
		this.end = end;
		this.cost = weight;
	}

	@Override
	public int compareTo(Node o) {
		return cost - o.cost;
	}
}

public class Main {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final int INF = Integer.MAX_VALUE;
	static int v, e, k;
	static List<Node>[] list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		list = new ArrayList[v + 1];
		dist = new int[v + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		// 리스트에 그래프 정보를 초기화
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			// start에서 end로 가는 weight 가중치
			list[start].add(new Node(end, weight));
		}

		StringBuilder sb = new StringBuilder();
		// 다익스트라 알고리즘
		dijkstra(k);
		// 출력 부분
		for (int i = 1; i <= v; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[v + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cNode = pq.poll();
			int curr = cNode.end;
			if(check[curr]) continue;
			check[curr] = true;
			
			for (Node next : list[curr]) {
				if(dist[next.end] > dist[curr] + next.cost) {
					dist[next.end] = dist[curr] + next.cost;
					pq.offer(new Node(next.end, dist[next.end]));
				}
			}
		}
	}
}