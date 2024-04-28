import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Point {
		int r, c;

		public Point(final int c, final int r) {
			this.c = c;
			this.r = r;
		}
	}

	static int N, M, L, K;
	static List<Point> points = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			points.add(new Point(r, c));
		}
		int res = Integer.MIN_VALUE;

		for (Point p1 : points) {
			for (Point p2 : points) {
				res = Math.max(res, count(p1.r, p2.c));
			}
		}

		System.out.println(K - res);
	}

	private static int count(int r, int c) {
		int ans = 0;
		for (Point p : points) {
			if (p.r >= r && p.r <= r + L && p.c >= c && p.c <= c + L) ans++;
		}
		return ans;
	}
}
