import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		dfs(0, 0);
		System.out.println(sb.toString());
	}

	static void dfs(int index, int count) {
		if (count == M) {
			for (int i = 0; i < N; i++) {
				if (visit[i]) {
					sb.append(i + 1).append(" ");
				}
			}
			sb.append("\n");
			return;
		}
		if (index == N) {
			return;
		}
		visit[index] = true;
		dfs(index + 1, count + 1);
		visit[index] = false;
		dfs(index + 1, count);

	}
}
