import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] printArr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visit = new boolean[N];
		printArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0, 0);
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i : printArr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			printArr[depth] = arr[i];
			dfs(i, depth + 1);
		}
	}

}
