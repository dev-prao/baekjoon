import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		char[] charN = n.toCharArray();
		for (int i = charN.length - 1; i >= 0; i--) {
			System.out.print(charN[i]);
		}
		br.close();
	}
}
