import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] relations;
	static boolean[] isChecked;
	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		relations = new ArrayList[n + 1];
		isChecked = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			relations[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int firstPerson = Integer.parseInt(st.nextToken());
		int secondPerson = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			relations[parent].add(child);
			relations[child].add(parent);
		}
		dfs(firstPerson, secondPerson, 0);
		System.out.println(result);
	}

	private static void dfs(final int start, final int end, final int count) {
		if (start == end) {
			result = count;
			return;
		}
		isChecked[start] = true;
		for (int i = 0; i < relations[start].size(); i++) {
			int next = relations[start].get(i);
			if (!isChecked[next]) {
				dfs(next, end, count + 1);
			}
		}
	}
}
