import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqL = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqR = new PriorityQueue<>();

		pqR.add(Integer.parseInt(br.readLine()));
		sb.append(pqR.peek()).append("\n");
		for (int i = 2; i <= N; i++) {
			int n = Integer.parseInt(br.readLine());

			int mid = pqR.peek();
			if (n < mid) {
				if (pqL.size() == pqR.size()) {
					if (pqL.peek() > n) {
						pqR.add(pqL.poll());
						pqL.add(n);
					} else {
						pqR.add(n);
					}
				} else {
					pqL.add(n);
				}

			} else {
				if (pqR.size() - pqL.size() == 1) {
					pqL.add(pqR.poll());
				}
				pqR.add(n);
			}

			if (i % 2 == 0) {
				sb.append(pqL.peek());
			} else {
				sb.append(pqR.peek());
			}
			sb.append("\n");
		}
//		System.out.println("size = " + pqL.size() + " / " + pqR.size());
//		System.out.println("=====");
//		while(!pqL.isEmpty()) {
//			System.out.println(pqL.poll());
//		}
//		System.out.println("=====");
//		System.out.println("=====");
//		while(!pqR.isEmpty()) {
//			System.out.println(pqR.poll());
//		}
//		System.out.println("=====");
		System.out.println(sb);

	}
}