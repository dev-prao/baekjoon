import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Deque<Docs> queue = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(final Integer o1, final Integer o2) {
				return o2 - o1;
			}
		});
		//테스트 개수 입력
		int T = Integer.parseInt(br.readLine());
		//테스트 개수만큼 반복
		for (int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine());
			//문서의 개수 N, 궁금한 문서 번호 target 입력
			int N = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int priority = Integer.parseInt(st.nextToken());
				pq.add(priority);
				queue.add(new Docs(i, priority));
			}

			int count = 1;
			
			while (!queue.isEmpty()) {
				Docs curr = queue.poll();
				int fp = pq.poll();
				if (curr.priority == fp && target == curr.number) {
					System.out.println(count);
					break;
				}
				if (curr.priority == fp) {
					count++;
				} else {
					queue.add(curr);
					pq.add(fp);
				}
			}
			queue.clear();
			pq.clear();
		}
	}

	static class Docs {
		int number;
		int priority;

		public Docs(int number, int priority) {
			this.number = number;
			this.priority = priority;
		}
	}
}
