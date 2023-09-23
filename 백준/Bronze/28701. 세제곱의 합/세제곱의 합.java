import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		int sum = 0;
		int squareSum = 0;
		int cubeSum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			cubeSum += i * i * i;
		}
		squareSum = sum * sum;
		System.out.println(sum);
		System.out.println(squareSum);
		System.out.println(cubeSum);
	}
}