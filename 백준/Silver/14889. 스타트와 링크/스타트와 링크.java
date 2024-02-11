import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static boolean[] team;
	static int[][] ability;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		team = new boolean[n];
		StringTokenizer st;

		ability = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(n / 2, 0);

		System.out.println(min);
	}

	public static void combination(int rest, int start) {
		if (rest == 0) {
			compareTeam();
			return;
		}

		for (int i = start; i <= n - rest; i++) {
			team[i] = true;
			combination(rest - 1, i + 1);
			team[i] = false;
		}
	}

	public static void compareTeam() {
		int startTeam = 0;
		int linkTeam = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (team[i] && team[j]) {
					startTeam += ability[i][j];
				} else if (!team[i] && !team[j]) {
					linkTeam += ability[i][j];
				}
			}
		}

		if (Math.abs(startTeam - linkTeam) < min) {
			min = Math.abs(startTeam - linkTeam);
		}
	}
}
