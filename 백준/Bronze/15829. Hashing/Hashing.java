import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		String string = br.readLine();
		br.close();
		long result = 0;
		long pow = 1;

		for (int i = 0; i < length; i++) {
			result += ((string.charAt(i) - 96) * pow);
			pow = (pow * 31) % 1234567891;
		}
		System.out.println(result % 1234567891);
	}
}
