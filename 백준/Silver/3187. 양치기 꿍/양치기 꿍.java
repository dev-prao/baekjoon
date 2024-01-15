import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static char[][] village;
    static boolean[][] isChecked;
    static int[] count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int sheep = 0;
    static int wolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); //가로
        C = Integer.parseInt(st.nextToken()); //세로
        village = new char[R][C];
        isChecked = new boolean[R][C];
        count = new int[2];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                village[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (canMove(i, j)) {
                    dfs(i, j);
                    addResult(sheep, wolf);
                    sheep = 0;
                    wolf = 0;
                }
            }
        }
        System.out.println(count[0] + " " + count[1]);
        br.close();
    }

    private static void dfs(int x, int y) {
        isChecked[x][y] = true;
        if (village[x][y] == 'k') {
            sheep++;
        }
        if(village[x][y] == 'v') {
            wolf++;
        }
        if (village[x][y] != '#') {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canMove(nx, ny)) {
                    dfs(nx, ny);
                }
            }
        }

    }

    private static void addResult(int k, int v) {
        if (k > v) {
            count[0] += k;
            return;
        }
        count[1] += v;
    }

    private static boolean canMove(int x, int y) {
        return isValidRange(x, y) && village[x][y] != '#' && !isChecked[x][y];
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
