import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, root, count;
	static int[] parents;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parents = new int[N];
		isVisited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int node = Integer.parseInt(st.nextToken());
			parents[i] = node;
			if (node == -1) {
				root = i;
			}
		}

		int deleteNode = Integer.parseInt(br.readLine());
		delete(deleteNode);

		count = 0;
		countLeaf(root);
		System.out.println(count);
		br.close();
	}

	private static void countLeaf(int index) {
		boolean isLeaf = true;
		isVisited[index] = true;
		if (parents[index] != -2) {
			for (int i = 0; i < N; i++) {
				if (parents[i] == index && !isVisited[i]) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if (isLeaf) {
				count++;
			}
		}
	}

	private static void delete(int index) {
		parents[index] = -2;
		for (int i = 0; i < N; i++) {
			if (parents[i] == index) {
				delete(i);
			}
		}
	}
}