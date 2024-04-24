import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Player[] players = new Player[p];
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());

			int level = Integer.parseInt(st.nextToken());
			String id = st.nextToken();
			players[i] = new Player(level, id);
		}

		for (int i = 0; i < p; i++) {
			List<Player> room = new ArrayList<>();
			if (!players[i].flag) {
				for (int j = i; j < p; j++) {
					if (room.size() == m) {
						break;
					}
					int level = players[j].level;
					String id = players[j].id;

					if (!players[j].flag
						&& players[i].level - 10 <= level && players[i].level + 10 >= level) {
						players[j].flag = true;
						room.add(new Player(level, id));
					}
				}

				Collections.sort(room);
				if (room.size() == m) {
					sb.append("Started!").append('\n');
				} else {
					sb.append("Waiting!").append('\n');
				}

				for (Player player : room) {
					sb.append(player.level).append(' ').append(player.id).append('\n');
				}
			}
		}

		System.out.print(sb);
	}

	public static class Player implements Comparable<Player> {
		int level;
		String id;
		boolean flag;

		Player(int level, String id) {
			this.level = level;
			this.id = id;
		}

		@Override
		public int compareTo(Player o) {
			return this.id.compareTo(o.id);
		}
	}
}
