import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Jewelry implements Comparable<Jewelry> {

		int weight, value;

		public Jewelry(final int weight, final int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(final Jewelry o) {
			return weight - o.weight == 0 ? o.value - value : weight - o.weight;
		}
	}

	static int N, K; //N(보석 개수), K(가방 개수)
	static int M, V; //M(무게), V(가격)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Jewelry[] jewelries = new Jewelry[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			jewelries[i] = new Jewelry(M, V);
		}

		Arrays.sort(jewelries);

		int[] bagLimit = new int[K];
		for (int i = 0; i < K; i++) {
			bagLimit[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(bagLimit);

		//가격 내림차순
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;
		for (int i = 0, j = 0; i < K; i++) {
			//현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣는다
			while (j < N && jewelries[j].weight <= bagLimit[i]) {
				pq.offer(jewelries[j++].value);
			}

			//우선순위 큐에 있는 요소를 빼서 가방에 넣음(가장 큰 가격)
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
	}
}
