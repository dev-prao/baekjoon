import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr, printArr;
	static boolean[] visit;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		printArr = new int[M];
		visit = new boolean[N];
		ans = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		dfs(0);

		for (String s : ans) {
			sb.append(s).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
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
