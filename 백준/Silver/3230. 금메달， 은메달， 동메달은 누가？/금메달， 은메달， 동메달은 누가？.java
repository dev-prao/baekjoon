import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[101];
		int[] ans = new int[101];

		for (int i = 1; i <= n; i++) {
			int rank = Integer.parseInt(br.readLine());

			if (arr[rank] != 0 && i != 1) {
				for (int j = i - 1; j >= rank; j--) {
					arr[j + 1] = arr[j];
				}
				arr[rank] = i;
			} else {
				arr[rank] = i;
			}
		}

		for (int i = 1; i <= m; i++) {
			int rank = Integer.parseInt(br.readLine());
			int player = arr[m - i + 1];

			if (ans[rank] != 0 && i != 1) {
				for (int j = i - 1; j >= rank; j--) {
					ans[j + 1] = ans[j];
				}
				ans[rank] = player;
			} else {
				ans[rank] = player;
			}
		}

		for (int i = 1; i <= 3; i++) {
			System.out.println(ans[i]);
		}
	}
}
