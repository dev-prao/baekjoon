import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1m^2의 넓이에 자라는 참외 개수를 헤아린 다음, 참외밭의 넓이를 구하면 비례식을 이용하여
 * 참외의 총 개수를 구할 수 있다.
 * 참외밭은 ㄱ자 모양 또는 ㄱ자를 90도, 180도, 270도 회전한 모양의 육각형
 * 밭의 경계(육각형의 변)는 모두 동서 방향이거나 남북 방향
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine());
		int[] length = new int[6];
		int maxWidth = -1;
		int maxHeight = -1;
		int maxWidthIdx = -1;
		int maxHeightIdx = -1;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			length[i] = dist;
			//가로 - 1(동),2(서)
			//세로 - 3(남),4(북)
			if (dir == 1 || dir == 2) {
				maxWidth = Math.max(maxWidth, dist);
				if (maxWidth == dist) maxWidthIdx = i;
				continue;
			}
			if (dir == 3 || dir == 4) {
				maxHeight = Math.max(maxHeight, dist);
				if (maxHeight == dist) maxHeightIdx = i;
			}
		}
		int left, right;
		if (maxWidthIdx + 1 >= 6) right = 0;
		else right = maxWidthIdx + 1;

		if (maxWidthIdx - 1 < 0) left = 5;
		else left = maxWidthIdx - 1;
		int minHeight = Math.min(length[left], length[right]);

		if (maxHeightIdx + 1 >= 6) right = 0;
		else right = maxHeightIdx + 1;

		if (maxHeightIdx - 1 < 0) left = 5;
		else left = maxHeightIdx - 1;
		int minWidth = Math.min(length[left], length[right]);

		int area = maxWidth * maxHeight - (maxWidth - minWidth) * (maxHeight - minHeight);
		System.out.println(area * K);
	}
}
