import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> listen = new HashSet<>();
		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}

		List<String> answer = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if (listen.contains(input)) {
				answer.add(input);
			}
		}

		Collections.sort(answer);

		for (String s : answer) {
			sb.append(s).append("\n");
		}

		bw.write(answer.size() + "\n" + sb);
		bw.flush();
		bw.close();
		br.close();
	}
}
