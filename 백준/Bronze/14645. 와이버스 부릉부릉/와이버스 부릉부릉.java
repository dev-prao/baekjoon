import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //출발역과 종착역을 제외한 정거장의 수
		int K = Integer.parseInt(st.nextToken()); //출발역에서 탑승하는 사람의 수
		
		//N개의 줄에 걸쳐 각 줄마다 i번째 정거장에서 탑승하는 인원 A와 하차하는 인원 B
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
		}
		System.out.println("비와이");
		br.close();
	}
}
