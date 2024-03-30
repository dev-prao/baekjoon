import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] r = new long[N + 1];
		long[] c = new long[N + 1];
		long sumPlus = 0, sumMinus = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}

		r[N] = r[0];
		c[N] = c[0];

		for (int i = 0; i < N; i++) {
			sumPlus += r[i] * c[i + 1];
			sumMinus += r[i + 1] * c[i];
		}

		String area = String.format("%.1f", (Math.abs(sumPlus - sumMinus) / 2.0));
		bw.write(area);

		br.close();
		bw.flush();
		bw.close();
	}
}
