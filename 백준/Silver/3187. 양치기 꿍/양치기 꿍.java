import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] village;
    static boolean[][] isChecked;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int sheep;
    static int wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); //가로
        C = Integer.parseInt(st.nextToken()); //세로
        village = new char[R][C];
        isChecked = new boolean[R][C];

        int sheeps = 0;
        int wolves = 0;

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                village[i][j] = input.charAt(j);
                if (village[i][j] == 'k') {
                    sheeps++;
                }
                if (village[i][j] == 'v') {
                    wolves++;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((village[i][j] == 'k' || village[i][j] == 'v') && !isChecked[i][j]) {
                    sheep = 0;
                    wolf = 0;
                    if (village[i][j] == 'k') {
                        sheep = 1;
                    }
                    else if (village[i][j] == 'v') {
                        wolf = 1;
                    }
                    dfs(i, j);
                    if (sheep > wolf) {
                        wolves -= wolf;
                    } else {
                        sheeps -= sheep;
                    }
                }
            }
        }
        System.out.println(sheeps + " " + wolves);
        br.close();
    }

    private static void dfs(int x, int y) {
        isChecked[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isChecked[nx][ny] || isOut(nx, ny) || village[nx][ny] == '#') {
                continue;
            }
            if (village[nx][ny] == 'k') {
                sheep++;
            }
            if (village[nx][ny] == 'v') {
                wolf++;
            }
            dfs(nx, ny);
        }
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 && x >= R || y >= C;
    }
}
