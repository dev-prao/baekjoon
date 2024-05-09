import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		int[] B = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(B);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += A[i] * B[n - i - 1];
		}

		System.out.println(ans);
	}
}
