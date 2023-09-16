import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strNum = br.readLine();
		br.close();

		int count = 0;

		while (true) {
			long sum = 0;
			if (strNum.length() == 1) {
				break;
			}
			for (int i = 0; i < strNum.length(); i++) {
				sum += Integer.parseInt(String.valueOf(strNum.charAt(i)));
			}
			count++;
			strNum = String.valueOf(sum);
		}

		if (Integer.parseInt(String.valueOf(strNum)) % 3 == 0) {
			System.out.println(count + "\nYES");
		}
		if (Integer.parseInt(String.valueOf(strNum)) % 3 != 0) {
			System.out.println(count + "\nNO");
		}
	}
}
