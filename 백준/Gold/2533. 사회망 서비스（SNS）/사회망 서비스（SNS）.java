import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][2]; // dp[node][0]: 얼리 어답터 X, dp[node][1]: 얼리 어답터 O
        visited = new boolean[N + 1];

        // 트리 초기화
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        // DFS로 DP 계산
        dfs(1);

        // 최소 얼리 어답터 개수 출력
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // 얼리 어답터가 아닌 경우
        dp[node][1] = 1; // 얼리 어답터인 경우

        for (int child : tree.get(node)) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += dp[child][1]; // 자식이 얼리 어답터여야 함
                dp[node][1] += Math.min(dp[child][0], dp[child][1]); // 자식이 얼리 어답터일 수도, 아닐 수도 있음
            }
        }
    }
}
