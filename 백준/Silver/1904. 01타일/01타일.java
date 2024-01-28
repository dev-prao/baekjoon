import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		bw.write(countTile(N) + "");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int countTile(int num) {
		if (num == 1) {
			return 1;
		}
		if (num == 2) {
			return 2;
		}
		int v1 = 1;
		int v2 = 2;
		int sum = 0;

		for (int i = 2; i < num; i++) {
			sum = (v1 + v2) % 15746;
			v1 = v2;
			v2 = sum;
		}
		return sum;
	}
}
