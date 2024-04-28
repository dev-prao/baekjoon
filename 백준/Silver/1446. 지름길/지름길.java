import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static class Node {
		int end;
		int cost;

		Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int d = Integer.parseInt(input[1]);

		List<Node>[] nodes = new ArrayList[d + 1];
		int[] dp = new int[d + 1];

		for (int i = 0; i <= d; i++) {
			nodes[i] = new ArrayList<>();
			dp[i] = i;
		}
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int dist = Integer.parseInt(input[2]);
			if(end > d) continue;
			nodes[start].add(new Node(end, dist));
		}

		for (int i = 0; i < d; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

			for (Node next : nodes[i]) {
				if (dp[i] + next.cost < dp[next.end])
					dp[next.end] = dp[i] + next.cost;
			}
		}

		System.out.println(dp[d]);
	}
}
