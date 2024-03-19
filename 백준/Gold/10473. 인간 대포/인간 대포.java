
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

	static class Position {
		double r, c;

		public Position(double r, double c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Edge implements Comparable<Edge> {
		int dest;
		float time;

		public Edge(int dest, float time) {
			this.dest = dest;
			this.time = time;
		}

		@Override
		public int compareTo(Main.Edge o) {
			return Float.compare(time, o.time);
		}
	}

	static Position start, end;
	static boolean[] check;
	static float[] times;
	static Position[] points;
	static List<Edge>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		float r = Float.parseFloat(input[0]);
		float c = Float.parseFloat(input[1]);
		start = new Position(r, c);

		input = br.readLine().split(" ");
		r = Float.parseFloat(input[0]);
		c = Float.parseFloat(input[1]);
		end = new Position(r, c);

		int N = Integer.parseInt(br.readLine());
		check = new boolean[N + 2];
		times = new float[N + 2];
		points = new Position[N + 2];
		adjList = new ArrayList[N + 2];
		for (int i = 0; i < N + 2; i++) {
			adjList[i] = new ArrayList<>();
		}

		points[0] = start;
		points[N + 1] = end;
		for (int i = 1; i < N + 1; i++) {
			input = br.readLine().split(" ");
			r = Float.parseFloat(input[0]);
			c = Float.parseFloat(input[1]);
			points[i] = new Position(r, c);
		}
		
		for (int i = 1; i < N + 2; i++) {
			adjList[0].add(new Edge(i, (float)(getDist(points[0], points[i]) / 5.0)));
		}
		

		for (int i = 1; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				float dist = getDist(points[i], points[j]);
				adjList[i].add(new Edge(j, (float) Math.min(dist / 5.0, Math.abs(dist - 50) / 5.0 + 2)));
			}

		}

		dijkstra(0);
		bw.write(String.valueOf(times[N + 1]));
		bw.close();
		br.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Arrays.fill(times, Integer.MAX_VALUE);
		pq.add(new Edge(start, 0));
		times[start] = 0;

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			int dest = edge.dest;
			if (check[dest]) continue;
			check[dest] = true;
			for (Edge next : adjList[dest]) {
				if (times[next.dest] >= times[dest] + next.time) {
					times[next.dest] = times[dest] + next.time;
					pq.add(new Edge(next.dest, times[next.dest]));
				}
			}
		}
	}
	
	static float getDist(Position a, Position b) {
		return (float)Math.sqrt(Math.pow(a.r - b.r, 2) + Math.pow(a.c - b.c, 2));
	}
}