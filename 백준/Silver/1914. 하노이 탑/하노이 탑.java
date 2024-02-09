import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		if (n <= 20) {
			sb.append((int)(Math.pow(2, n) - 1)).append("\n");
			hanoi(n, 1, 2, 3);
		} else {
			sb.append(getBigNumber(n)).append("\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static BigInteger getBigNumber(int n) {
		return new BigInteger("2").pow(n).subtract(BigInteger.ONE);
	}

	private static void hanoi(int n, int start, int temp, int end) {
		if (n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		hanoi(n - 1, start, end, temp);

		sb.append(start).append(" ").append(end).append("\n");

		hanoi(n - 1, temp, start, end);
	}
}
