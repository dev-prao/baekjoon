import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Meeting implements Comparable<Meeting> {
		int begin, end;

		Meeting(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end != o.end) return this.end - o.end;
			return this.begin - o.begin;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(begin, end);
		}

		Arrays.sort(meetings);

		int maxCountOfMeetings = 0;
		int endOfLastMeeting = 0;

		for (Meeting m : meetings) {
			if (endOfLastMeeting <= m.begin) {
				maxCountOfMeetings++;
				endOfLastMeeting = m.end;
			}
		}

		System.out.println(maxCountOfMeetings);
		br.close();
	}

}
