import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 double result = Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
			 sb.append(String.format("$%.2f", result)).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}