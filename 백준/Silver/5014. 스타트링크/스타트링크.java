import java.util.*;
import java.io.*;

public class Main {
	static int[] floor;
	static boolean[] visit;
	static int[] move;
	static int F, S, G, U, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		floor = new int[F + 1];
		visit = new boolean[F + 1];
		move = new int[] { U, -D };

		bfs(S);
	}

	public static void bfs(int S) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(S);
		visit[S] = true;
		floor[S] = 0;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (curr == G) {
				System.out.println(floor[curr]);
				return;
			}
			for (int i = 0; i < 2; i++) {
				int nowfloor = curr + move[i];
				if (nowfloor >= 1 && nowfloor <= F) {
					if (!visit[nowfloor]) {
						queue.add(nowfloor);
						visit[nowfloor] = true;
						floor[nowfloor] = floor[curr] + 1;

					}
				}
			}

		}
		System.out.println("use the stairs");
	}
}