import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 2];

		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		int idx = 0;
		long ans = 0;
		if(B <= C) {
			for (int i = 0; i < N; i++) {
				ans += B * arr[i];
			}
			System.out.println(ans);
			return;
		}
		
		while (idx < N) {
			if (arr[idx] > 0) {
				int temp = arr[idx];
				ans += B * temp;
				temp = Math.min(temp, arr[idx + 1]);
				ans += C * temp;
				arr[idx + 1] -= temp;
				temp = Math.min(temp, arr[idx + 2] - Math.min(arr[idx + 1], arr[idx + 2]));
				ans += C * temp;
				arr[idx + 2] -= temp;
			}
			idx++;
		}
		System.out.println(ans);
	}
}
