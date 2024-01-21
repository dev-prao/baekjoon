import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] chess;
	static int[][] move = {
		{-2, -1}, {-2, 1},
		{-1, -2}, {-1, 2},
		{1, -2}, {1, 2},
		{2, -1}, {2, 1}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		chess = new int[N + 1][N + 1];

		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		bfs(new Point(X, Y));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(chess[A][B]).append(" ");
		}

		System.out.println(sb);
	}

	private static void bfs(Point knight) {
		Queue<Point> que = new ArrayDeque<>();
		que.add(knight);
		while (!que.isEmpty()) {
			Point target = que.poll();
			for (int i = 0; i < 8; i++) {
				int nx = target.x + move[i][0];
				int ny = target.y + move[i][1];
				if (nx < 1 || ny < 1 || nx > N || ny > N || chess[nx][ny] != 0) {
					continue;
				}
				chess[nx][ny] = chess[target.x][target.y] + 1;
				que.add(new Point(nx, ny));
			}
		}
	}
}

class Point {
	int x;
	int y;

	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
}
