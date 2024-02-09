import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] switches = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int studentsCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < studentsCount; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (gender == 1) {
				int count = 1;
				while (num * count <= N) {
					switches[num * count] ^= 1;
					count++;
				}
			} else {
				int start = num - 1;
				int end = num + 1;
				while (start >= 1 && end <= N) {
					if (switches[start] != switches[end])
						break;
					start--;
					end++;
				}
				start++;
				end--;

				for (int j = start; j <= end; j++) {
					switches[j] ^= 1;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			bw.write(switches[i] + " ");
			if (i % 20 == 0) {
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}