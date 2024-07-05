import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, M;
	static int[] seq;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		seq = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		M = Integer.parseInt(br.readLine());

		if(Arrays.stream(seq).sum() <= M) {
			System.out.println(Arrays.stream(seq).max().getAsInt());
			return;
		}

		Arrays.sort(seq);
		binarySearch(1, seq[N-1]);
		System.out.println(result);
	}

	static void binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int total = calculate(mid);

			if (total <= M) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
	}

	static int calculate(int money) {
		int total = 0;
		for(int n : seq) {
			total += Math.min(n, money);
		}
		return total;
	}
}
