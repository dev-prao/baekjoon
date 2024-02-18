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
			double dist = 0;

			double rad = Math.toRadians(X);
			double left = T * 100 - (16.0 / Math.sin(rad));
			double right = T * 100 + (16.0 / Math.sin(rad));

			double step = ((double)105 / 2 - 10) * 2 / Math.tan(rad);

			while (dist < right) {
				if (dist > left) {
					System.out.println("yes");
					break;
				}
				dist += step;
				if (dist >= right) {
					System.out.println("no");
				}
			}
		}
	}
}
