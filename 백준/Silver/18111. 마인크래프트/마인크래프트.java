import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] field = new int[n][m];
		int maxHeight = Integer.MIN_VALUE;
		int minHeight = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int value = Integer.parseInt(st.nextToken());
				field[i][j] = value;
				maxHeight = Math.max(maxHeight, value);
				minHeight = Math.min(minHeight, value);
			}
		}
		br.close();

		int totalTime = Integer.MAX_VALUE; //시간
		int height = -1; //층

		for (int i = minHeight; i <= maxHeight; i++) { //최소층 ~ 최대층
			int time = 0;
			int inventory = b;

			for (int j = 0; j < field.length; j++) {
				for (int k = 0; k < field[j].length; k++) {
					int diff = field[j][k] - i;

					if (diff > 0) {
						time += Math.abs(diff) * 2;
						inventory += Math.abs(diff);
					}
					if (diff <= 0) {
						time += Math.abs(diff);
						inventory -= Math.abs(diff);
					}
				}
			}

			if (inventory >= 0 && time <= totalTime) {
				totalTime = time;
				height = i;
			}
		}

		bw.write(totalTime + " " + height);
		bw.flush();
		bw.close();
	}
}
