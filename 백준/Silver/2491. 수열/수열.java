import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dpUp = new int[N];
		int[] dpDown = new int[N];
		
		int ascMax = 1;
		int descMax = 1;
		
		dpUp[0] = 1;
		dpDown[0] = 1;
		
		//오름차순
		for(int i = 1; i < N; i++) {
			if(arr[i] >= arr[i-1]) {
				dpUp[i] = dpUp[i-1] + 1;
			} else {
				dpUp[i] = 1;
			}
			ascMax = Math.max(ascMax, dpUp[i]);
		}
		
		//내림차순
		for(int i = 1; i < N; i++) {
			if(arr[i] <= arr[i-1]) {
				dpUp[i] = dpUp[i-1] + 1;
			} else {
				dpUp[i] = 1;
			}
			descMax = Math.max(descMax, dpUp[i]);
		}
		
		bw.write(String.valueOf(Math.max(ascMax, descMax)));
		bw.close();
		br.close();
	}
}