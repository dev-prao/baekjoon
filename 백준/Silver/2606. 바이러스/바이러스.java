import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visit;
	static List<Integer>[] conn;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		visit = new boolean[n + 1];
		conn = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			conn[i] = new ArrayList<>();
		}

		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			conn[u].add(v);
			conn[v].add(u);
		}

		bfs();
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}

	static void bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visit[1] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : conn[curr]) {
				if (visit[next])
					continue;
				q.offer(next);
				visit[next] = true;
				count++;
			}
		}
	}
}
