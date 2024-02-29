import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] fishBall = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i)
			fishBall[i] = Integer.parseInt(st.nextToken());
		int answer = 0;
		while (true) {
			// 물고기 수 차이가 K 이하가 되면 그만둔다.
			if (getDifference(fishBall) <= K)
				break;
			// 횟수 카운팅
			answer++;
//			// step1
//			System.out.println("==================== 1 번 ====================");
//			for (int i = 0; i < fishBall.length; i++) {
//				System.out.print("[" + fishBall[i] + "]");
//			}
//			System.out.println();
			// step2 물고기의 수가 가장 적은 어항에 물고기를 한 마리 넣는다.
//			System.out.println("==================== 2 번 ====================");
			addToMin(fishBall);
//			for (int i = 0; i < fishBall.length; i++) {
//				System.out.print("[" + fishBall[i] + "]");
//			}
//			System.out.println();
			// step3 가장 왼쪽에 있는 어항을 그 어항의 오른쪽에 있는 어항의 위에 올려 놓는다.
//			System.out.println("==================== 3 번 ====================");
			int[][] step3 = new int[2][fishBall.length - 1];
			moveLeftToRightUp(fishBall, step3);
//			for (int i = 0; i < step3.length; i++) {
//				for (int j = 0; j < step3[0].length; j++) {
//					System.out.print("[" + step3[i][j] + "]");
//				}
//				System.out.println();
//			}
			// step4 2개 이상 쌓여있는 어항을 모두 공중 부양시킨 다음, 전체를 시계방향으로 90도 회전
			// step4 공중 부양시킨 어항 중 가장 오른쪽에 있는 어항의 아래에 바닥에 있는 어항이 있을때까지 반복한다.
//			System.out.println("==================== 4 번 ====================");
			int[][] step4 = rotateClock90(step3);
//			for (int i = 0; i < step4.length; i++) {
//				for (int j = 0; j < step4[i].length; j++) {
//					System.out.print("[" + step4[i][j] + "]");
//				}
//				System.out.println();
//			}
//			// step5 모든 인접한 두 어항에 대해서, 물고기 수의 차이를 구하고 물고기를 이동시킨다.
//			System.out.println("==================== 5 번 ====================");
			controlNumberOfFish(step4);
//			for (int i = 0; i < step4.length; i++) {
//				for (int j = 0; j < step4[0].length; j++) {
//					System.out.print("[" + step4[i][j] + "]");
//				}
//				System.out.println();
//			}
//
//			// step6 어항을 바닥에 일렬로 놓아야 한다.
//			System.out.println("==================== 6 번 ====================");
			int[] step6 = lineUp(step4);
//			for (int i = 0; i < step6.length; i++) {
//				System.out.print("[" + step6[i] + "]");
//			}
//			System.out.println();
//			// step7 가운데를 중심으로 왼쪽 N/2개를 공중 부양시켜 전체를 시계 방향으로 180도 회전
//			System.out.println("==================== 7 번 ====================");
			int[][] step7 = rotateClock180(step6);
//			for (int i = 0; i < step7.length; i++) {
//				for (int j = 0; j < step7[i].length; j++) {
//					System.out.print("[" + step7[i][j] + "]");
//				}
//				System.out.println();
//			}
//			// step8 다시 위에서 한 물고기 조절 작업을 수행
//			System.out.println("==================== 8 번 ====================");
			controlNumberOfFish(step7);
//			for (int i = 0; i < step7.length; i++) {
//				for (int j = 0; j < step7[i].length; j++) {
//					System.out.print("[" + step7[i][j] + "]");
//				}
//				System.out.println();
//			}
//			
//			// step9 다시 위에서 한 물고기 조절 작업을 수행
//			System.out.println("==================== 9 번 ====================");
//			int[] step9 = lineUp(step7);
//			for (int i = 0; i < step9.length; i++) {
//				System.out.print("[" + step9[i] + "]");
//			}
//			System.out.println();
			fishBall = lineUp(step7);
		}
		System.out.println(answer);
	}

	// step2. 물고기의 수가 가장 적은 어항에 물고기를 한 마리 넣는다.
	static void addToMin(int[] fishBall) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < fishBall.length; ++i) {
			min = Math.min(min, fishBall[i]);
		}
		for (int i = 0; i < fishBall.length; ++i) {
			if (fishBall[i] == min)
				fishBall[i]++;
		}
	}

	// step3. 가장 왼쪽에 있는 어항을 그 어항의 오른쪽에 있는 어항의 위에 올려 놓는다.
	static void moveLeftToRightUp(int[] map, int[][] step3) {
		step3[0][0] = map[0];
		for (int j = 0; j < step3[0].length; j++) {
			step3[1][j] = map[j + 1];
		}
	}

	// step4. 2개 이상 쌓여있는 어항을 모두 공중 부양시킨 다음, 전체를 시계방향으로 90도 회전
	static int[][] rotateClock90(int[][] step3) {
		int[][] res = step3;
		while (true) {
			int targetC = 0;
			// 2개 이상인 열의 마지막 위치를 찾는다.
			for (int j = 0; j < res[0].length; ++j) {
				if (res[res.length - 2][j] != 0)
					targetC++;
				else
					break;
			}

			if (res.length > res[0].length - targetC)
				break;

			int nr = targetC + 1;
			int nc = res[0].length - targetC;
			int[][] tmp = new int[nr][nc];

			int sr = res.length - 1; // 밑에서 위로
			int sc = 0;
			boolean isLeftSide = true;

			for (int i = 0; i < nr; i++) {
				for (int j = 0; j < nc; j++) {
					if (isLeftSide) {
						if (sr >= 0)
							tmp[i][j] = res[sr--][sc];
					} else {
						tmp[i][j] = res[sr][sc++];
					}
				}

				sr = res.length - 1;
				if (isLeftSide && ++sc >= targetC) {
					isLeftSide = false;
					sc = targetC;
					sr = res.length - 1;
				}
			}
			res = tmp;
//			for (int i = 0; i < res.length; i++) {
//				for (int j = 0; j < res[0].length; j++) {
//					System.out.print(res[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		return res;
	}

	// step5. 공중 부양 작업이 모두 끝나면 어항에 있는 물고기의 수를 조절한다.
	static void controlNumberOfFish(int[][] step4) {
		int row = step4.length;
		int col = step4[0].length;
		int[][] val = new int[row][col];
		for (int r = 0; r < row; ++r) {
			for (int c = 0; c < col; ++c) {
				int curr = step4[r][c];
				if (curr == 0)
					continue;
				for (int d = 0; d < 4; d++) {
					int nr = r + move[d][0];
					int nc = c + move[d][1];
					if (0 <= nr && nr < row && 0 <= nc && nc < col) {
						if (step4[nr][nc] == 0)
							continue;
						int next = step4[nr][nc];
						int diff = Math.abs(curr - next) / 5;
						if (diff > 0) {
							if (curr < next) {
								val[r][c] += diff;
							} else if (curr > next) {
								val[r][c] -= diff;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				step4[i][j] += val[i][j];
			}
		}
	}

	// step6 다시 어항을 바닥에 일렬로 놓는다.
	static int[] lineUp(int[][] step5) {
		int[] res = new int[N];
		int idx = 0;
		for (int c = 0; c < step5[0].length; c++) {
			for (int r = step5.length - 1; r >= 0; r--) {
				if (step5[r][c] == 0)
					continue;
				res[idx++] = step5[r][c];
			}
		}
		return res;
	}

	// step7 가운데를 중심으로 왼쪽 N/2개를 공중부양시켜 전체를시계 방향으로 180도 회전시킨 다음 올느쪽 N/2개의 위에 놓는다.
	// 이 작업은 두번 반복한다. 두번 반복하면 바닥에 있는 어항의 수는 N/4개가 된다.
	static int[][] rotateClock180(int[] step6) {
		int row = 2;
		int col = step6.length / 2;
		int[][] res = new int[row][col];
		int[] tmp = new int[col];
		for (int c = 0; c < tmp.length; c++) {
			tmp[c] = step6[col - c - 1];
		}

		res[0] = tmp;
		for (int c = 0; c < col; c++) {
			res[1][c] = step6[col + c];
		}
//		for(int i = 0; i < row; i++) {
//			for( int j = 0; j < col; j++) {
//				System.out.print("[" + res[i][j] + "]");
//			}
//			System.out.println();
//		}

		row *= 2;
		col /= 2;
		int[][] res2 = new int[row][col];
		int[][] tmp2 = new int[row / 2][col];
		for (int r = 0; r < row / 2; r++) {
			for (int c = 0; c < col; c++) {
				tmp2[r][c] = res[row / 2 - r - 1][col - c - 1];
			}
		}
		
		for(int r = row / 2; r < row; r++) {
			for(int c = 0; c < col; c++) {
				res2[r][c] = res[r - row / 2][c + col];
			}
		}
		
		for(int r = 0; r < row/2; r++) {
			for(int c = 0; c < col; c++) {
				res2[r][c] = tmp2[r][c];
			}
		}
		
		return res2;
	}

	// 물고기 수 차이가 K 이하가 되면 그만둔다.
	static int getDifference(int[] map) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < map.length; ++i) {
			max = Math.max(max, map[i]);
			min = Math.min(min, map[i]);
		}
		return max - min;
	}
}
