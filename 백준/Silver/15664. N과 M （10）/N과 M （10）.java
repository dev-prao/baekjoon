import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int n, m;
	private static int[] arr;
	private static int[] res;
	private static boolean[] visit;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		arr = new int[n];
		res = new int[m];
		visit = new boolean[n];

		input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		bt(0, 0, sb);
		System.out.print(sb);

	}

	private static void bt(int idx, int cnt, StringBuilder sb) {
		if (cnt == m) {
			for (int i = 0; i < m; i++) {
				sb.append(res[i] + " ");
			}
			sb.append("\n");
			return;
		}

		int num = 0;
		for (int i = idx; i < n; i++) {
			if (!visit[i]) {
				if (num == arr[i]) continue;
				visit[i] = true;
				res[cnt] = arr[i];
				bt(i + 1, cnt + 1, sb);
				visit[i] = false;
				num = arr[i];
			}
		}

	}
}
