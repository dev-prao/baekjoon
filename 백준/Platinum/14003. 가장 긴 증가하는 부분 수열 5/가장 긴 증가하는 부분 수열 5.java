import java.io.*;
import java.util.*;

public class Main {

	private static final int MAX = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] dp = new int[MAX];
		dp[0] = arr[0];

		int[] result = new int[arr.length];
		result[0] = 0;

		int size = 1;
		for (int i = 1; i < N; i++) {
			int index = Arrays.binarySearch(dp, 0, size, arr[i]);
			index = index >= 0 ? index : Math.abs(index) - 1;
			dp[index] = arr[i];
			if (index == size) size++;
			result[i] = index;
		}

		String[] LIS = new String[size];
		sb.append(size).append("\n");
		size--;
		for (int j = arr.length - 1; j >= 0; j--) {
			if (size == -1) break;
			if (result[j] == size) {
				LIS[size] = String.valueOf(arr[j]);
				size--;
			}
		}
		for (String s : LIS) {
			sb.append(s).append(" ");
		}

		System.out.println(sb);
	}
}
