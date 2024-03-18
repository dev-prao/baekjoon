import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int[] sortedArr = Arrays.copyOf(arr, N);
		Arrays.sort(sortedArr);
		int idx = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (map.containsKey(sortedArr[i])) continue;
			map.put(sortedArr[i], idx++);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
