import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			deque.add(i);
		}
		while (!deque.isEmpty()) {
			if (deque.size() == 1) {
				System.out.println(deque.poll());
				break;
			}
			deque.poll();
			deque.add(deque.poll());
		}
	}
}
