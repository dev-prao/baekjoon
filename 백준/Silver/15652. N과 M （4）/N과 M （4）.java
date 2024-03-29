import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer> list;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		dfs(0);
		System.out.println(sb.toString());
	}

	static void dfs(int index) {
		if (list.size() == M) {
			for (int i : list) {
				sb.append(i + 1).append(" ");
			}
			sb.append("\n");

			return;
		}
		if (index == N) {
			return;
		}

		list.add(index);
		dfs(index);
		list.remove(list.size() - 1);
		dfs(index + 1);

	}
}
