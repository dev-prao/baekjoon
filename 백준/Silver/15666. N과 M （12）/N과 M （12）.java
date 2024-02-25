import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] ans;
	static List<Integer> list;
	static LinkedHashSet<String> set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		set = new LinkedHashSet<>();
		ans = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!list.contains(num)) {
				list.add(num);
			}
		}

		Collections.sort(list);

		dfs(0, 0);
		for (String s : set) {
			sb.append(s).append('\n');
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	static void dfs(int start, int depth) {
		if (depth == M) {
			if (M == 1) {
				for (int i : list) {
					set.add(String.valueOf(i));
				}
				return;
			}
			StringBuilder nsb = new StringBuilder();
			for (int i = 0; i < ans.length - 1; i++) {
				if (ans[i] > ans[i + 1]) {
					return;
				}
				if (i == ans.length - 2 && (ans[i] <= ans[ans.length - 1])) {
					nsb.append(ans[i]).append(" ").append(ans[i + 1]);
					set.add(nsb.toString());
					return;
				}
				nsb.append(ans[i]).append(" ");
			}
			return;
		}

		for (int i = start; i < list.size(); i++) {
			ans[depth] = list.get(i);
			dfs(start, depth + 1);
		}
	}
}
