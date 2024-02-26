import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, node;
	static boolean[] visit;
	static List<Node>[] tree;
	static int max = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			tree[num] = new ArrayList<>();
			while(st.hasMoreTokens()) {
				int end = Integer.parseInt(st.nextToken());
				if(end == -1) {
					break;
				}
				int cost = Integer.parseInt(st.nextToken());
				tree[num].add(new Node(end, cost));
			}
		}
		visit = new boolean[N+1];
		dfs(1,0);
		visit = new boolean[N+1];
		dfs(node,0);
		System.out.println(max);
	}
	
	static void dfs(int idx, int cost) {
		if(cost > max) {
			node = idx;
			max = cost;
		}
		visit[idx] = true;
		
		for(Node next : tree[idx]) {
			if(!visit[next.end]) {
				dfs(next.end, cost + next.cost);
				visit[next.end] = true;
			}
		}
	}
	
	static class Node {
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
}