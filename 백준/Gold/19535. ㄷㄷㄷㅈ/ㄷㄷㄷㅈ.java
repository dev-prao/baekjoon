import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	private static final String EQUAL = "DUDUDUNGA";
	static long D, G;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] lines = new long[N + 1];
		Deque<int[]> deque = new ArrayDeque<>();

		while (--N > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			lines[u]++;
			lines[v]++;
			deque.add(new int[] {u, v});
		}

		while (!deque.isEmpty()) {
			int[] now = deque.poll();
			D += ((lines[now[0]] - 1) * (lines[now[1]] - 1));
		}

		for (long line : lines) {
			if (line >= 3) {
				G += (line * (line - 1) * (line - 2)) / 6;
			}
		}

		if (D > 3 * G) {
			bw.write("D");
		} else if (D < 3 * G) {
			bw.write("G");
		} else {
			bw.write(EQUAL);
		}
		bw.close();
		br.close();
	}
}
