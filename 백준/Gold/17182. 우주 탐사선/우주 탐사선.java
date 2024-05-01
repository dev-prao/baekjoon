import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean[] isVisited;
	static int[][] dist;

	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[N][N];
		isVisited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < N; l++) {
					if (dist[i][l] > dist[i][j] + dist[j][l]) {
						dist[i][l] = dist[i][j] + dist[j][l];
					}
				}
			}
		}

		dfs(K, 0, 0);
		System.out.println(answer);
	}

	public static void dfs(int start, int curDist, int depth) {
		if (depth == N - 1) {
			answer = Math.min(curDist, answer);
			return;
		}

		isVisited[start] = true;
		for (int i = 0; i < N; i++) {
			if (isVisited[i]) continue;
			dfs(i, curDist + dist[start][i], depth + 1);
		}
		isVisited[start] = false;
	}
}
