import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = { 0, 0, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dc = { -1, 1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][] map = new int[h][w];

        for (int r = 0; r < h; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < w; c++) {
                map[r][c] = st.nextToken().charAt(0) - '0';
            }
        }

        int[][] isVisited = new int[h][w];

        Deque<int[]> q = new ArrayDeque<int[]>();

        isVisited[0][0] = 1;
        q.offer(new int[] { 1, 0, 0 });
        int ans = -1; // depth를 의미

        while (!q.isEmpty()) {

            // 들어갈 때마다 moveCnt 증가하는 셈.
            // > 1 depth 증가
            ans++;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] curPos = q.poll();
                int curJump = curPos[0];
                int curR = curPos[1];
                int curC = curPos[2];

                if (curR == h - 1 && curC == w - 1) {
                    System.out.println(ans);
                    br.close();
                    return;
                }

                for (int d = 0; d < 12; d++) {
                    // 말 이동 횟수 없으면 4방향 탐색까지만
                    if (d > 3 && curJump == k + 1)
                        break;

                    int nr = curR + dr[d];
                    int nc = curC + dc[d];
                    int tempJump = curJump;
                    if (d >= 4)
                        tempJump++;

                    // 범위 초과 시
                    if (nr < 0 || nc < 0 || nr >= h || nc >= w)
                        continue;
                    // 장애물 or 말 이동 횟수 덜 사용하고 이미 방문 시
                    // > 이미 방문했다면 0보단 커야함!
                    if (map[nr][nc] == 1 || (isVisited[nr][nc] > 0 && isVisited[nr][nc] <= tempJump)) {
                        continue;
                    }
                    isVisited[nr][nc] = tempJump;
                    q.offer(new int[] { tempJump, nr, nc });
                }
            }
        }

        System.out.println(-1);
        br.close();
    }

}