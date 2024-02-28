import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, ans;
    static int[][] startPos;
    static int[] d = {2, 2, 0, 0};
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ans = Integer.MIN_VALUE;
        startPos = new int[][] {
                {0, 0},			// 상
                {N - 1, 0},		// 하
                {0, 0},			// 좌
                {0, N - 1}		// 우
        };
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);

        System.out.println(ans);
    }

    static void dfs(int depth, int[][] curBoard) {
        if (depth == 5) return;

        int[][] tmpBoard;

        for (int i = 0; i < 4; i++) {
            tmpBoard = deepCopy(curBoard);
            detect(i, tmpBoard);
            merge(i, tmpBoard);
            dfs(depth + 1, tmpBoard);
        }
    }

    static void detect(int dir, int[][] board) {
        Stack<Integer[]> st = new Stack<>();
        int sr = startPos[dir][0];
        int sc = startPos[dir][1];

        int nr = sr, nc = sc;

        for (int i = 0; i < N; i++) {
            st.clear();
            for (int j = 0; j < N; j++) {
                int n = board[nr][nc];

                if (n != 0) {
                    if (st.isEmpty() || st.peek()[0] != n) st.push(new Integer[]{n, nr, nc});
                    // 같은 숫자면, 숫자 합치기
                    else if (st.peek()[0] == n) {
                        // 숫자 합치기
                        int my = st.peek()[1];
                        int mx = st.peek()[2];
                        merge(my, mx, nr, nc, board);
                        st.clear();
                    }
                }

                nr += dr[dir];
                nc += dc[dir];
            }

            // 다음 행 또는 열 단위 이동
            sr += dr[d[dir]];
            sc += dc[d[dir]];
            nr = sr;
            nc = sc;
        }
    }
    
    static void merge(int dir, int[][] board) {
        int sr = startPos[dir][0];
        int sc = startPos[dir][1];

        int nr = sr;
        int nc = sc;

        for (int rc = 0; rc < N; rc++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int n = board[nr][nc];

                if (n != 0) list.add(n);
                ans = Math.max(ans, n);
                nr += dr[dir];
                nc += dc[dir];
            }

            nr = sr;
            nc = sc;

            int j = 0;
            while (j < list.size()) {
                board[nr][nc] = list.get(j);
                j++;
                nr += dr[dir];
                nc += dc[dir];
            }
            while (j < N) {
                board[nr][nc] = 0;
                j++;
                nr += dr[dir];
                nc += dc[dir];
            }

            sr += dr[d[dir]];
            sc += dc[d[dir]];
            nr = sr;
            nc = sc;
        }
    }

    static void merge(int mr, int mc, int nr, int nc, int[][] board) {
        board[mr][mc] *= 2;
        board[nr][nc] = 0;
    }

    static int[][] deepCopy(int[][] curArray) {
        int[][] newArray = new int[N][];
        for (int i = 0; i < N; i++) {
            newArray[i] = Arrays.copyOf(curArray[i], N);
        }
        return newArray;
    }
}