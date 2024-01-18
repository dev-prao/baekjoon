import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		int[] temperature = new int[n];
		for(int i = 0; i < n; i++) {
			temperature[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i <= n - k; i++) {
			int sum = 0;
			for(int j = i; j < i + k; j++) {
				sum += temperature[j];
			}
			if(sum > max) {
				max = sum;
			}
		}
		
		System.out.println(max);
		br.close();
	}
}