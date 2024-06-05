import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] arr, printArr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		printArr = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(printArr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int before = -1;
		for (int i = 0; i < N; i++) {
			int now = arr[i];
			if (before != now) {
				before = now;
				printArr[depth] = arr[i];
				dfs(depth + 1);
			}

		}
	}
}