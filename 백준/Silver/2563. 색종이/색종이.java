import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		int result = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int maxX = x > 90 ? 100 : x + 10;
			int maxY = y > 90 ? 100 : y + 10;
			for (int j = x + 1; j <= maxX; j++) {
				for (int k = y + 1; k <= maxY; k++) {
					arr[j][k] = 1;
				}
			}
		}
		br.close();
		
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (arr[i][j] == 1) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
