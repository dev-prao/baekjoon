import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, K, cnt;
	static int[] arr, res;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		res = new int[N];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		bt(0);
		System.out.println(cnt);
	}

	static void bt(int depth) {
		if(depth == N && isValid()) {
			cnt++;
			return;
		}

		if(depth == N) return;

		for (int i = 0; i < N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			res[depth] = arr[i];
			bt(depth + 1);
			visit[i] = false;
		}
	}

	static boolean isValid() {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += (res[i] - K);
			if(ans < 0) return false;
		}
		return true;
	}
}
