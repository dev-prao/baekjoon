import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, res;
	static int[] team;
	static boolean[] done, visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());
			res = 0;
			team = new int[N + 1];
			done = new boolean[N + 1];
			visit = new boolean[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				team[i] = Integer.parseInt(st.nextToken());
				if(i == team[i]) {
					done[i] = true;
					res++;
				}
			}

			for (int i = 1; i < N + 1; i++) {
				if(done[i]) continue;
				dfs(i);
			}
			System.out.println(N - res);
		}
	}

	static void dfs(int idx) {
		if(visit[idx]) {
			done[idx] = true;
			res++;
		} else {
			visit[idx] = true;
		}
		
		if (!done[team[idx]]) dfs(team[idx]);

		visit[idx] = false;
		done[idx] = true;
	}
}
