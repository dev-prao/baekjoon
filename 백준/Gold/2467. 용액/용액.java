import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		int start = 0;
		int end = n - 1;
		int min = Integer.MAX_VALUE;
		int[] res = new int[2];
		
		while(start < end) {
			int sum = arr[start] + arr[end];
			
			if(sum == 0) {
				res[0] = arr[start];
				res[1] = arr[end];
				break;
			}
			
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				res[0] = arr[start];
				res[1] = arr[end];
			}
			
			if(sum > 0) {
				end--;
			} else if(sum < 0) {
				start++;
			}
		}
		
		System.out.println(res[0] + " " + res[1]);
	}
}