import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //수열의 크기
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine()); //질문의 개수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(isPalindrome(arr, s - 1, e - 1)) {
				sb.append("1\n");
				continue;
			}
			sb.append("0\n");
		}

		System.out.println(sb);
	}

	public static boolean isPalindrome(int[] arr, int s, int e) {
		while(true) {
			if(s == e) return true;
			if(s + 1 == e && arr[s] == arr[e]) return true;
			if(arr[s] == arr[e]) {
				s++;
				e--;
			} else {
				return false;
			}
		}
	}
}
