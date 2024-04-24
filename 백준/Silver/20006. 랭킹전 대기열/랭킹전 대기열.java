import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Player implements Comparable<Player> {
		int lv;
		String id;
		boolean isInRoom;

		public Player(int lv, String id) {
			this.lv = lv;
			this.id = id;
		}

		@Override
		public int compareTo(Player o) {
			return id.compareTo(o.id);
		}
	}
	
	static int lv;
	static String id;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Player[] players = new Player[p];
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());

			lv = Integer.parseInt(st.nextToken());
			id = st.nextToken();
			players[i] = new Player(lv, id);
		}

		for (int i = 0; i < p; i++) {
			List<Player> room = new ArrayList<>();
			if (!players[i].isInRoom) {
				for (int j = i; j < p; j++) {
					if (room.size() == m) break;
					lv = players[j].lv;
					id = players[j].id;

					if (!players[j].isInRoom && players[i].lv - 10 <= lv
						&& players[i].lv + 10 >= lv) {
						players[j].isInRoom = true;
						room.add(new Player(lv, id));
					}
				}

				Collections.sort(room);
				if (room.size() == m) {
					sb.append("Started!").append('\n');
				} else {
					sb.append("Waiting!").append('\n');
				}

				for (Player player : room) {
					sb.append(player.lv).append(' ').append(player.id).append('\n');
				}
			}
		}

		System.out.print(sb);
	}
}
