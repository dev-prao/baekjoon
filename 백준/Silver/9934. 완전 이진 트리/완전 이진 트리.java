import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	static int K;
	static int[] arr;
	static StringBuilder[] answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		K = Integer.parseInt(br.readLine());
		arr = new int[(int)Math.pow(2, K) - 1];
		

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        answer = Arrays.stream(arr)
                .mapToObj(StringBuilder::new)
                .toArray(StringBuilder[]::new);
        
        dfs(0, arr.length - 1, 0);
        
        for(int i = 0; i < K; i++) {
        	bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
	}
	
	private static void dfs(int start, int end, int level) {
		if(level == K) return;
		int mid = (start + end) / 2;
		answer[level].append(arr[mid] + " ");
		
		dfs(start, mid - 1, level + 1);
		dfs(mid + 1, end, level + 1);
	}
	
}