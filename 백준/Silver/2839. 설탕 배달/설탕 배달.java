import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		int quotient = n / 5;
		int remainder = n % 5;
		int answer = 0;

		if (remainder == 0) {
			answer = quotient;
		}
		if (remainder == 1 || remainder == 3) {
			answer = quotient + 1;
		}
		if (remainder == 2 || remainder == 4) {
			answer = quotient + 2;
		}
		if (n == 4 || n == 7) {
			answer = -1;
		}

		System.out.println(answer);
	}
}
