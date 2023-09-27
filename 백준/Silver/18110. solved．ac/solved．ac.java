import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cut = (int)Math.round(n * 0.15);
		int sum = 0;

		ArrayList<Integer> level = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			level.add(Integer.parseInt(br.readLine()));
		}
		br.close();

		Collections.sort(level);

		for (int i = cut; i < n - cut; i++) {
			sum += level.get(i);
		}

		int avg = Math.round((float)sum / (n - 2 * cut));
		System.out.println(avg);
	}
}
