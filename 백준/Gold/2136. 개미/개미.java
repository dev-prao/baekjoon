import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Ant implements Comparable<Ant> {
		int x;
		int index;

		public Ant(int x, int index) {
			this.x = x;
			this.index = index;
		}

		@Override
		public int compareTo(final Ant o) {
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int lDist = 0;
		int rDist = 0;
		int lIdx = 0;

		Ant[] ants = new Ant[N];

		for (int i = 0; i < ants.length; i++) {
			int pos = Integer.parseInt(br.readLine());
			if (pos < 0) {
				lIdx++;
				ants[i] = new Ant(-pos, i + 1);
				if (-pos > lDist) lDist = -pos;
				continue;
			}
			ants[i] = new Ant(pos, i + 1);
			if (L - pos > rDist) rDist = L - pos;
		}

		Arrays.sort(ants);

		int time = 0;
		int idx = 0;

		if (lDist >= rDist) {
			time = lDist;
			idx = ants[lIdx - 1].index;
		} else {
			time = rDist;
			idx = ants[lIdx].index;
		}

		System.out.println(idx + " " + time);
	}
}
