import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n, d, k, c, result, cnt;

	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //접시
		d = Integer.parseInt(st.nextToken()); //가짓수
		k = Integer.parseInt(st.nextToken()); //연속
		c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			set.clear();
			cnt = 0;
			int j = i;

			while (true) {
				cnt += 1;
				if (j == n) j = 0;
				set.add(arr[j++]);
				if (cnt == k) break;
			}
			set.add(c);
			result = Math.max(result, set.size());

		}
		System.out.println(result);

	}

}
