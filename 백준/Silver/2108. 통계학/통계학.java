import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		int maxCount = Integer.MIN_VALUE;
		for (int value : map.values()) {
			if (value > maxCount) {
				maxCount = value;
			}
		}

		List<Integer> modes = new ArrayList<>();
		for (int value : map.keySet()) {
			if (map.get(value) == maxCount) {
				modes.add(value);
			}
		}

		Collections.sort(modes);

		int avg = (int)Math.round((double)sum / N);
		int mid = arr[N / 2];
		int modeNum = 0;
		if (modes.size() > 1) {
			modeNum = modes.get(1);
		} else {
			modeNum = modes.get(0);
		}
		int range = max - min;

		sb.append(avg)
			.append("\n")
			.append(mid)
			.append("\n")
			.append(modeNum)
			.append("\n")
			.append(range);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
