import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		int n;
		String[] words;
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			words = new String[n];
			for (int i = 0; i < n; i++) {
				words[i] = br.readLine();
			}
			Arrays.sort(words);

			boolean flag = true;
			for (int i = 1; i < n; i++) {
				if (words[i].startsWith(words[i - 1])) {
					flag = false;
					break;					
				}
			}
			
			if(flag) {
				sb.append("YES").append("\n");
			} else {				
				sb.append("NO").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
