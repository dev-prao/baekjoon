import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int K;
	static int[][] farm;
	static boolean[][] isVisited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int count;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			farm = new int[M][N];
			isVisited = new boolean[M][N];
			
			K = Integer.parseInt(st.nextToken());
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[x][y] = 1;
			}
			
			for(int x = 0; x < M; x++) {
				for(int y = 0; y < N; y++) {
					if(canMove(x,y)) {
						dfs(x,y);
						count++;						
					}
				}
			}
			System.out.println(count);
		}
		br.close();
	}

	private static void dfs(int x, int y) {
		isVisited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(canMove(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}
	
	private static boolean canMove(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N && !isVisited[x][y] && farm[x][y] == 1;
	}
}