import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	static List<Long> decreasingNumbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		decreasingNumbers = new ArrayList<>();

		bw.write(String.valueOf(getDecreasingNumber(n)));
		bw.close();
		br.close();
	}

	private static long getDecreasingNumber(int n) {
		if (n <= 10) {
			return n;
		} else if (n >= 1023) {
			return -1;
		} else {
			for (int i = 0; i < 10; i++) {
				backtracking(i, 1);
			}
			Collections.sort(decreasingNumbers);
			return decreasingNumbers.get(n);
		}
	}

	private static void backtracking(long number, int index) {
		if (index > 10) {
			return;
		}

		decreasingNumbers.add(number);
		for (int i = 0; i < number % 10; i++) {
			backtracking((number * 10) + i, index + 1);
		}
	}
}
