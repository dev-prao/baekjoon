import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int answer;
            int dx = x2 - x1;
            int dy = y2 - y1;
            long distanceSquared = dx * dx + dy * dy;

            if (distanceSquared == 0) {
                if (r1 == r2) {
                    answer = -1;
                } else {
                    answer = 0;
                }
            } else {
                long radiusSumSquared = (r1 + r2) * (r1 + r2);
                long radiusDiffSquared = (r1 - r2) * (r1 - r2);

                if (distanceSquared < radiusSumSquared && distanceSquared > radiusDiffSquared) {
                    answer = 2;
                } else if (distanceSquared == radiusSumSquared || distanceSquared == radiusDiffSquared) {
                    answer = 1;
                } else {
                    answer = 0;
                }
            }

            System.out.println(answer);
        }
        br.close();
    }
}
