import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<Integer, String> pocketmons1 = new HashMap<>();
		Map<String, Integer> pocketmons2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String input = br.readLine();
			pocketmons1.put(i, input);
			pocketmons2.put(input, i);
		}
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
				sb.append(pocketmons1.get(Integer.parseInt(input))).append("\n");
			} else {
				sb.append(pocketmons2.get(input)).append("\n");
			}

		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
