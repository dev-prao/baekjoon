import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int time = Integer.parseInt(st.nextToken());

		int x = (p + time) % (2 * w);
		int y = (q + time) % (2 * h);
		
		if(x > w) {
			x = 2 * w - x;
		}
		if(y > h) {
			y = 2 * h - y;
		}

		System.out.println(x + " " + y);
		br.close();
	}


}
