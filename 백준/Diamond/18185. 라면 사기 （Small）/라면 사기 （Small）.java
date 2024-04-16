import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 2];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int idx = 0;
		int ans = 0;
		while (idx < N) {
			if (arr[idx] > 0) {
				int temp = arr[idx];
				ans += 3 * temp;
				temp = Math.min(temp, arr[idx + 1]);
				ans += 2 * temp;
				arr[idx + 1] -= temp;
				temp = Math.min(temp, arr[idx + 2] - Math.min(arr[idx + 1], arr[idx + 2]));
				ans += 2 * temp;
				arr[idx + 2] -= temp;
			}
			idx++;
		}
		System.out.println(ans);
	}
}
