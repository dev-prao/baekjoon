import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Position {
		double r, c;

		public Position(final double r, final double c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Star implements Comparable<Star> {
		int start, end;
		double weight;

		public Star(final int start, final int end, final double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(final Star o) {
			return Double.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Star{" + "start=" + start + ", end=" + end + ", weight=" + weight + '}';
		}
	}

	static int N;
	static int[] parents;
	static Position[] positions;
	static List<Star> stars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		positions = new Position[N];
		stars = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double r = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());
			positions[i] = new Position(r, c);
		}

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				double weight = getDist(positions[i], positions[j]);
				stars.add(new Star(i, j, weight));
			}
		}

		makeSet();
		Collections.sort(stars);
		int cnt = 0;
		double answer = 0;

		for (Star star : stars) {
			if (union(star.start, star.end)) {
				cnt += 1;
				answer += star.weight;
			}
			if (cnt == N) break;
		}

		answer = (int)(answer * 100) / 100.0;
		bw.write(String.valueOf(answer));
		bw.close();
		br.close();
	}

	static void makeSet() {
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if (parentA == parentB) return false;
		parents[parentB] = parents[parentA];
		return true;
	}

	static int find(int idx) {
		if (parents[idx] == idx) return idx;
		return find(parents[idx]);
	}

	static double getDist(Position p1, Position p2) {
		return Math.sqrt(Math.pow(Math.abs(p1.r - p2.r), 2) + Math.pow(Math.abs(p1.c - p2.c), 2));
	}
}
