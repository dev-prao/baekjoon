import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] arr;
	static int N, S, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0);

		if (S == 0) System.out.println(res - 1);
			// S가 0일 때, 공집합이 포함되어 있으므로 -1
		else System.out.println(res);
	}

	private static void dfs(int depth, int sum) {
		if (depth == N) {
			if (sum == S) res++;
			return;
		}

		dfs(depth + 1, sum + arr[depth]);
		dfs(depth + 1, sum);
	}
}
