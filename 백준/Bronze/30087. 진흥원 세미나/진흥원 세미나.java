import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String, String> seminar = new HashMap<>();
		seminar.put("Algorithm", "204");
		seminar.put("DataAnalysis", "207");
		seminar.put("ArtificialIntelligence", "302");
		seminar.put("CyberSecurity", "B101");
		seminar.put("Network", "303");
		seminar.put("Startup", "501");
		seminar.put("TestStrategy", "105");

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String room = seminar.get(br.readLine());
			sb.append(room).append("\n");
		}
		br.close();
		System.out.println(sb);
	}
}
