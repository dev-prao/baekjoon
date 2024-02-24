import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] printArr;
	static boolean[] visit;
	static List<String> p;
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
		p = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0);
		for (String s : p) {
			sb.append(s).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void dfs(int depth) {
		if (depth == M) {
			StringBuilder s = new StringBuilder();
			for (int i : printArr) {
				s.append(i).append(" ");
			}
			if (!p.contains(s.toString())) {
				p.add(s.toString());
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				printArr[depth] = arr[i];
				visit[i] = true;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

}
