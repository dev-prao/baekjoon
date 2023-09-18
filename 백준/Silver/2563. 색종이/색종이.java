import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int blackArea = 0; // 검은 영역의 넓이
		int n = Integer.parseInt(br.readLine()); // 색종이 개수
		boolean[][] canvas = new boolean[101][101]; // 도화지

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// (x, y)부터 (x+9, y+9)까지의 영역을 하나씩 체크하여 검은 영역을 더해줍니다.
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					if (!canvas[j][k]) {
						canvas[j][k] = true;
						blackArea++;
					}
				}
			}
		}

		System.out.print(blackArea);
	}
}
