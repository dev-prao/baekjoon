import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int population[];
	static List<Integer>[] conn;
	static boolean select[];
	static boolean visit[];
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = Integer.MAX_VALUE;
		population = new int[N];
		select = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		conn = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			conn[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken()); // 인접 구역 수
			for (int j = 0; j < cnt; j++) {
				int num = Integer.parseInt(st.nextToken());
				conn[i].add(num - 1);
			}
		}

		dfs(0);
		if (answer == Integer.MAX_VALUE)
			answer = -1;
		System.out.println(answer);

	}

	private static void dfs(int index) {
		if (index == N) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (select[i])
					aList.add(i);
				else
					bList.add(i);
			}
			if (aList.size() == 0 || bList.size() == 0)
				return;

			if (check(aList) && check(bList)) {
				getDiff();
			}
			return;
		}

		select[index] = true;
		dfs(index + 1);
		select[index] = false;
		dfs(index + 1);
	}

	private static boolean check(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		visit = new boolean[N];
		visit[list.get(0)] = true;
		q.offer(list.get(0));

		int count = 1;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i = 0; i < conn[curr].size(); i++) {
				int y = conn[curr].get(i);
				if (list.contains(y) && !visit[y]) {
					q.offer(y);
					visit[y] = true;
					count++;
				}
			}
		}
		
		if (count == list.size()) {
			return true;
		} else {
			return false;
		}
	}

	private static void getDiff() {
		int pA = 0, pB = 0;
		for (int i = 0; i < N; i++) {
			if (select[i])
				pA += population[i];
			else
				pB += population[i];
		}
		int diff = Math.abs(pA - pB);
		answer = Math.min(answer, diff);
	}
}