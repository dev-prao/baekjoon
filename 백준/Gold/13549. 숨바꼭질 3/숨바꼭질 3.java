import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static class Loc {
		int idx;
		int time;

		public Loc(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int n = Integer.parseInt(inputs[0]);
		int k = Integer.parseInt(inputs[1]);

		int[] visited = new int[100001];

		Deque<Loc> q = new ArrayDeque<>();
		q.add(new Loc(n, 1)); //방문 체크를 위해 1
		visited[n] = 1;

		while (!q.isEmpty()) {
			Loc now = q.poll();

			if (now.idx + 1 >= 0 && now.idx + 1 <= 100000 && (visited[now.idx + 1] == 0
				|| visited[now.idx + 1] > now.time + 1)) {
				visited[now.idx + 1] = now.time + 1;
				q.add(new Loc(now.idx + 1, now.time + 1));
			}

			if (now.idx - 1 >= 0 && now.idx - 1 <= 100000 && (visited[now.idx - 1] == 0
				|| visited[now.idx - 1] > now.time + 1)) {
				visited[now.idx - 1] = now.time + 1;
				q.add(new Loc(now.idx - 1, now.time + 1));
			}

			if (now.idx * 2 >= 0 && now.idx * 2 <= 100000 && (visited[now.idx * 2] == 0
				|| visited[now.idx * 2] > now.time)) {
				visited[now.idx * 2] = now.time;
				q.add(new Loc(now.idx * 2, now.time));
			}

		}

		System.out.println(visited[k] - 1);

	}
}
