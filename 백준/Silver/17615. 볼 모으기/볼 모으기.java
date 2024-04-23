import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int redB = 0;
		boolean flag = false;
		for(int i = n - 1; i >= 0; i--) {
			if(arr[i] == 'B') {
				flag = true;
				continue;
			}
			if(flag && arr[i] == 'R') {
				redB++;
			}
		}
		
		int redF = 0;
		flag = false;
		for(int i = 0; i < n; i++) {
			if(arr[i] == 'B') {
				flag = true;
				continue;
			}
			if(flag && arr[i] == 'R') {
				redF++;
			}
		}
		
		int blueB = 0;
		flag = false;
		for(int i = n - 1; i >= 0; i--) {
			if(arr[i] == 'R') {
				flag = true;
				continue;
			}
			if(flag && arr[i] == 'B') {
				blueB++;
			}
		}
		
		int blueF = 0;
		flag = false;
		for(int i = 0; i < n; i++) {
			if(arr[i] == 'R') {
				flag = true;
				continue;
			}
			if(flag && arr[i] == 'B') {
				blueF++;
			}
		}
//		System.out.println("빨간공 기준 back : " + redB);
//		System.out.println("빨간공 기준 front : " + redF);
//		System.out.println("파란공 기준 back : " + blueB);
//		System.out.println("파란공 기준 front : " + blueF);
		System.out.println(Math.min(Math.min(redB, redF), Math.min(blueB, blueF)));
	}
}