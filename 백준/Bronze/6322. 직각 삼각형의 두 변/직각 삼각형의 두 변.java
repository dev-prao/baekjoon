import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			double a = Double.parseDouble(st.nextToken());
			double b = Double.parseDouble(st.nextToken());
			double c = Double.parseDouble(st.nextToken());

			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			System.out.println("Triangle #" + test);

			if (a == -1) {
				if (c <= b)
					System.out.println("Impossible.");
				else {
					a = Math.sqrt((c * c) - (b * b));
					System.out.printf("a = " + "%.3f\n", a);
				}
			}
			if (b == -1) {
				if (c <= a)
					System.out.println("Impossible.");
				else {
					b = Math.sqrt((c * c) - (a * a));
					System.out.printf("b = " + "%.3f\n", b);
				}
			}
			if (c == -1) {
				c = Math.sqrt((a * a) + (b * b));
				System.out.printf("c = " + "%.3f\n", c);
			}
			test++;
			System.out.println();
		}
	}
}
