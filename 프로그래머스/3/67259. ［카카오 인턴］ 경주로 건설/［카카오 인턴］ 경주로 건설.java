import java.util.*;

class Solution {

	static int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; //하,우,상,좌
	static int[][] dp;
	static int[] dirSeq = new int[] {0, 2, 1, 3}; //하,상,우,좌
	static int minCost = Integer.MAX_VALUE;
	static int N;
	static boolean[][] isVisited;

	public int solution(int[][] board) {
		N = board.length;
		isVisited = new boolean[N][N];
		dp = new int[N][N];
		for (int r = 0; r < N; r++) {
			Arrays.fill(dp[r], Integer.MAX_VALUE - 600);
		}

		dp[0][0] = 0;
		dfs(board, 0, 0, -1, 0);
		return minCost;
	}

	void dfs(int[][] board, int r, int c, int preDir, int curCost) {
		if (r == N - 1 && c == N - 1) {
			minCost = Math.min(minCost, curCost);
			return;
		}

		if (curCost >= minCost || curCost > dp[r][c] + 600) return;

		dp[r][c] = curCost;

		for (int seq : dirSeq) {
			int[] d = dir[seq];
			int nr = r + d[0];
			int nc = c + d[1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !isVisited[nr][nc]
				&& board[nr][nc] != 1) {
				isVisited[nr][nc] = true;
				if (preDir == -1) {
					dfs(board, nr, nc, seq, curCost + 100);
				} else { //preDir % 2 == seq % 2 -> ex)0: 하, 상 / 1: 우, 좌 -> 0: 하, 우 / 1:상, 좌
					dfs(board, nr, nc, seq, curCost + 100 + 500 * (preDir % 2 != seq % 2 ? 1 : 0));
				}
				isVisited[nr][nc] = false;
			}
		}
	}
}
