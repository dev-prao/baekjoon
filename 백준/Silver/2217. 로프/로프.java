import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] rope = new int[n];
		for (int i = 0; i < n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		//50 40 30 20 10
		//10 8 6 4 2
		//12.5 10 7.5 5
		//rope[i] * k
		// w = n * minRope
		Arrays.sort(rope);
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, rope[i] * (n - i));
		}

		System.out.println(ans);
	}
}
