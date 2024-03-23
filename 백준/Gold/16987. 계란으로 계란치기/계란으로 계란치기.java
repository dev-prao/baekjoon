import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] durability;
	static int[] weight;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		durability = new int[N];
		weight = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			durability[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		backTracking(0, 0);
		System.out.println(max);
	}

	static void backTracking(int idx, int cnt) {
		if (idx == N) {
			max = Math.max(max, cnt);
			return;
		}

		if (durability[idx] <= 0 || cnt == N - 1) {
			backTracking(idx + 1, cnt);
			return;
		}

		int currCnt = cnt;

		for (int targetIdx = 0; targetIdx < N; targetIdx++) {
			if (targetIdx == idx || durability[targetIdx] <= 0) continue;
			collide(idx, targetIdx);
			if (durability[idx] <= 0) cnt++;
			if (durability[targetIdx] <= 0) cnt++;
			backTracking(idx + 1, cnt);
			rollback(idx, targetIdx);
			cnt = currCnt;
		}
	}

	static void collide(int curr, int target) {
		durability[curr] -= weight[target];
		durability[target] -= weight[curr];
	}

	static void rollback(int curr, int target) {
		durability[curr] += weight[target];
		durability[target] += weight[curr];
	}
}
