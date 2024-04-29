import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //동전의 종류
		int k = Integer.parseInt(st.nextToken()); //원하는 가치의 합

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int totalCnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			int cur = arr[i];
			if(cur > k) continue;
			int cnt = k / cur;
			k %= cur;
			totalCnt += cnt;
		}

		System.out.println(totalCnt);
	}
}
