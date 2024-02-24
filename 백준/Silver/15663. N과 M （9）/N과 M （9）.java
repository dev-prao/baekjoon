import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr, printArr;
	static boolean[] visit;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		printArr = new int[M];
		visit = new boolean[N];
		ans = new LinkedHashSet<>();

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		Arrays.sort(arr);
		dfs(0);
		ans.forEach(System.out::println);
	}

	static void dfs(int depth) {
		if (depth == M) {
			StringBuilder sb = new StringBuilder();
			for (int p : printArr) {
				sb.append(p).append(' ');
			}
			ans.add(sb.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				printArr[depth] = arr[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}