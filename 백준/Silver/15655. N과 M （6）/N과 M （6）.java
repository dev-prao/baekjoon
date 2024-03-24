import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

class Main {

	static int N, M;
	static int[] arr;
	static boolean[] check;
	static LinkedHashSet<String> ans = new LinkedHashSet<>();
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		bt(0, 0);
		for (String sb : ans) {
			System.out.print(sb);
		}
	}

	static void bt(int idx, int cnt) {
		if (cnt == M) {
			sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			ans.add(sb.toString());
			return;
		}

		if (idx == N) return;

		for (int i = idx; i < N; i++) {
			if (check[i]) continue;
			check[i] = true;
			bt(idx + 1, cnt + 1);
			check[i] = false;
			bt(idx + 1, cnt);
		}
	}
}
