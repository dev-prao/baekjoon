import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] arr, lis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		lis = new int[N];
		Arrays.fill(lis,1);

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		lis[0] = arr[0];
		int length = 1;

		for (int i = 1; i < N; i++) {
			int key = arr[i];
			if(key > lis[length - 1]) {
				length++;
				lis[length - 1] = key;
				continue;
			}

			int lo = 0;
			int hi = length;
			while(lo < hi) {
				int mid = (lo + hi) >>> 1;

				if(key > lis[mid]) {
					lo = mid + 1;
					continue;
				}
				hi = mid;
			}

			lis[lo] = key;
		}

		System.out.println(length);
	}
}
