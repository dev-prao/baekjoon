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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] blocks = new int[W];
		int water = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}


		for (int i = 0; i < W - 1; i++) {
			
			int leftTop = 0;
			int rightTop = 0;

			for(int j = 0; j < i; j++) {
				leftTop = Math.max(leftTop,blocks[j]);				
			}
			
			for (int j = i + 1; j < W; j++) {
				rightTop = Math.max(rightTop, blocks[j]);
			}
			
			int min = Math.min(leftTop, rightTop);
			if(min > blocks[i]) {
				water += min - blocks[i];
			}
		}

		bw.write(String.valueOf(water));
		bw.close();
		br.close();
	}
}