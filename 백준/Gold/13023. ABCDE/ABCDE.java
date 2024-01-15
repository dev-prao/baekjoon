import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> relation;
    static boolean[] isChecked;
    static int result = 0;
    private static final int STANDARD_DEPTH = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        relation = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            relation.add(new ArrayList<>());
        }
        isChecked = new boolean[N];
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation.get(a).add(b);
            relation.get(b).add(a);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (result == 1) {
                break;
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void dfs(int node, int depth) {
        if (depth == STANDARD_DEPTH) {
            result = 1;
            return;
        }
        isChecked[node] = true;
        for (int next : relation.get(node)) {
            if (!isChecked[next]) {
                dfs(next, depth + 1);
            }
        }
        isChecked[node] = false;
    }
}
