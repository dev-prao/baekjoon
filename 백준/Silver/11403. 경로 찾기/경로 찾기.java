import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];

		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N;j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int k = 0; k<N; k++){
			for(int i = 0; i<N; i++){
				for(int j = 0; j<N; j++){
					if(graph[i][k] == 1 && graph[k][j]==1){
						graph[i][j] = 1;
					}
				}
			}
		}

		for(int[] row: graph){
			for(int i :row){
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
