import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		long subInspector = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		for (int student : A) {
			int subSum = student - B;
			if (subSum > 0) {
				if (subSum % C == 0) {
					subInspector += subSum / C;
					continue;
				}
				subInspector += (subSum / C) + 1;
			}
		}

		bw.write((N + subInspector) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
