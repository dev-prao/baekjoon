import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 2];

		arr[0] = 0; //시작
		arr[N + 1] = L; //끝
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int left = 1;
		int right = L - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;

			for (int i = 1; i < arr.length; i++) {
				sum += (arr[i] - arr[i - 1] - 1) / mid; //딱 맞아 떨어지면 이미 휴게소 세워진 구간
			}

			if (sum > M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(left);
	}
}
