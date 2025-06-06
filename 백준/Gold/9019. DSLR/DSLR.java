import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            Queue<Integer> q = new LinkedList<>();
            boolean[] visit = new boolean[10000]; // BFS 탐색의 방문 여부 체크
            String[] command = new String[10000]; // 정답 명령어를 담는 배열


            q.add(start); // a를 큐에 담고
            visit[start] = true; // 방문 표시한다
            Arrays.fill(command,  "");


            while (!q.isEmpty() && !visit[target]) {
                int now = q.poll(); // 큐에서 값을 뺀다 = 현재 탐색 위치

                int D = (2 * now) % 10000; // n을 두배로 바꾸고 10000으로 나눈 나머지
                int S = now == 0 ? 9999 : now - 1; // 0일 때, 9999, 아니면 1을 빼준다 
                int L = (now % 1000) * 10 + now / 1000; // 1234 -> 2341 : 1234를 1000으로 나눈 나머지(234)에 10을 곱함=2340, 1234를 1000으로 나누면 1, 2340+1=2341
                int R = (now % 10) * 1000 + now / 10; // 1234 -> 4123 : 1234를 10으로 나눈 나머지에 1000 곱합 = 4000, 1234를 10으로 나누면 123, 4000+123=4123

                if (!visit[D]) {
                    q.add(D);
                    visit[D] = true;
                    command[D] = command[now] + "D";
                }

                if (!visit[S]) {
                    q.add(S);
                    visit[S] = true;
                    command[S] = command[now] + "S";
                }

                if (!visit[L]) {
                    q.add(L);
                    visit[L] = true;
                    command[L] = command[now] + "L";
                }

                if (!visit[R]) {
                    q.add(R);
                    visit[R] = true;
                    command[R] = command[now] + "R";
                }
            }
            System.out.println(command[target]);
        }
    }
}