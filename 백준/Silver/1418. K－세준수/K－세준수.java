import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 1; i <= N; i++) {
			if (sejunNumber(i) <= K) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static int sejunNumber(int n) {
		int maxFactor = 0;
		while (n % 2 == 0) {
			maxFactor = 2;
			n /= 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				maxFactor = i;
				n /= i;
			}
		}

		if (n > 1) {
			maxFactor = n;
		}

		return maxFactor;
	}
}
