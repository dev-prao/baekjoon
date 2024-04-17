import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 10번 이하로 가능 1 / 아니면 0
        // 빨간 구슬만 빠져야 함
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 빨간공, 파란공 좌표
        int redR = 0, redC = 0, blueR = 0, blueC = 0;

        // 맵 정보
        map = new char[n][m];
        for (int r = 0; r < n; r++) {
            String str = br.readLine();
            for (int c = 0; c < m; c++) {
                map[r][c] = str.charAt(c);

                if (map[r][c] == 'R') { // 빨간공 좌표 저장
                    redR = r;
                    redC = c;
                } else if (map[r][c] == 'B') { // 파란공 좌표 저장
                    blueR = r;
                    blueC = c;
                }
            }
        }

        // 정답 출력
        sb.append(bfs(redR, redC, blueR, blueC));
        System.out.println(sb);
    }

    // BFS 탐색
    static int bfs(int redR, int redC, int blueR, int blueC) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        q.add(new int[] { redR, redC, blueR, blueC });
        visited[redR][redC][blueR][blueC] = true; // 방문 체크

        int cnt = 0; // 이동한 횟수
        while (!q.isEmpty()) {
        	
        	if(cnt >= 10) {
        		return -1;
        	}

            int size = q.size();

            // 큐의 크기만큼 반복 -> 횟수 체크
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {
                    int[] red = { cur[0], cur[1] }; // 빨간공 좌표
                    int[] blue = { cur[2], cur[3] }; // 파란공 좌표

                    int redDist = move(red, d); // 빨간공 거리
                    int blueDist = move(blue, d); // 파란공 거리

                    boolean redFlag = false, blueFlag = false;
                    if (map[red[0]][red[1]] == 'O') // 빨간공이 구멍에 들어간 경우
                        redFlag = true;

                    if (map[blue[0]][blue[1]] == 'O') // 파란공이 구멍에 들어간 경우
                        blueFlag = true;

                    // 둘이 같은 좌표에 있는 경우, 먼 거리를 이동한 구슬이 한 칸 거꾸로 이동
                    if (red[0] == blue[0] && red[1] == blue[1]) {
                        if (redDist > blueDist) {
                            red[0] -= dr[d];
                            red[1] -= dc[d];
                        } else {
                            blue[0] -= dr[d];
                            blue[1] -= dc[d];
                        }
                    }

                    if (redFlag) { // 빨간 구슬이 빠진 경우
                        if (blueFlag) // 파란 구슬이 빠진 경우, 스킵
                            continue;
                        return cnt + 1; // 빨간 구슬만 빠진 경우, 1
                    } else {// 빨간 구슬이 안빠진 경우
                        if (blueFlag) // 파란 구슬이 빠진 경우, 스킵
                            continue;

                        // 이미 방문한 좌표인 경우, 스킵
                        if (visited[red[0]][red[1]][blue[0]][blue[1]])
                            continue;

                        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new int[] { red[0], red[1], blue[0], blue[1] });
                    }
                }
            }

            cnt++; // 횟수 증가
        }

        return -1;
    }

    // 구슬 이동
    static int move(int[] marble, int dir) {
        int dist = 0;

        while (true) {
            marble[0] += dr[dir];
            marble[1] += dc[dir];

            if (map[marble[0]][marble[1]] == '#') {
                marble[0] -= dr[dir];
                marble[1] -= dc[dir];
                break;
            } else if (map[marble[0]][marble[1]] == 'O') {
                break;
            }

            dist++;
        }

        return dist;
    }
}