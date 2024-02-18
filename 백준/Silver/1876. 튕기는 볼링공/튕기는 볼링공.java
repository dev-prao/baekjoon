import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double T = Double.parseDouble(st.nextToken());
			double X = Double.parseDouble(st.nextToken());
			double rail = 0;

			// sin 함수에는 라디안 값이 필요하므로 각도를 라디안으로 변환
			double rad = Math.toRadians(X);

			// 앞에서 치는 것과 뒤에서 치는 것에 대한 거리 계산
			double left = T * 100 - (16.0 / Math.sin(rad));
			double right = T * 100 + (16.0 / Math.sin(rad));

			// 한 번 옆에 부딪히고 중앙으로 돌아오기 위해 필요한 거리 계산
			double step = ((double)105 / 2 - 10) * 2 / Math.tan(rad);

			while (rail < right) {
				// T - (a+b), T + (a+b) 사이에 값이 있으면 충돌
				if (rail > left) {
					System.out.println("yes");
					break;
				}
				rail += step;
				if (rail >= right) {
					System.out.println("no");
				}
			}
		}
	}
}
