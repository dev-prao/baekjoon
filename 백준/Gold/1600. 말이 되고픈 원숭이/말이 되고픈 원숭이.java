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
        for(int r = 0; r < h; r++) {
            Arrays.fill(isVisited[r], 987654321);
        }
        Deque<int[]> q = new ArrayDeque<int[]>();
        isVisited[0][0] = 10;
        q.offer(new int[] { 0, 0, 0, 10 });
        int ans = -1;

        while (ans == -1 && !q.isEmpty()) {
            int curIter = q.size();

            while (curIter-- > 0) {
                int[] curPos = q.poll();
                int curJump = curPos[0];
                int curR = curPos[1];
                int curC = curPos[2];
                int moveCnt = curPos[3];

                if (curR == h - 1 && curC == w - 1) {
                    ans = moveCnt - 10;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];

                    if (curJump <= k && nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 0 && curJump < isVisited[nr][nc]) {
                        isVisited[nr][nc] = curJump;
                        q.offer(new int[] { curJump, nr, nc, moveCnt+1 });
                    }
                }

                for (int d = 4; d < 12; d++) {
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];

                    if (curJump < k && nr >= 0 && nr < h && nc >= 0 && nc < w && map[nr][nc] == 0 && curJump + 1 < isVisited[nr][nc]) {
                        isVisited[nr][nc] = curJump + 1;
                        q.offer(new int[] { curJump + 1, nr, nc, moveCnt + 1 });
                    }
                }
            }
        }
        
//        for(int r = 0; r < h; r++) {
//            for(int c = 0; c < w; c++) {
//                int res = isVisited[r][c];
//                res = res == Integer.MAX_VALUE ? 0 : res;
//                System.out.printf("%2d ", res);
//            }
//            System.out.println();
//        }

        System.out.println(ans);
        br.close();
    }

}