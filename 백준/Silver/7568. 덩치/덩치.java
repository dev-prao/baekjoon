import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사람의 수 N을 입력받습니다.

        int[][] arr = new int[N][2]; // 각 사람의 몸무게와 키를 저장하는 배열입니다.
        // arr[N][0]: 몸무게, arr[N][1]: 키

        // 각 사람의 몸무게와 키를 입력받습니다.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 몸무게 입력
            arr[i][1] = Integer.parseInt(st.nextToken()); // 키 입력
        }

        StringBuilder sb = new StringBuilder();

        // 각 사람에 대해 등수를 계산합니다.
        for (int i = 0; i < N; i++) {
            int rank = 1; // 초기 등수를 1로 설정합니다.

            // 다른 사람들과 비교하여 등수를 계산합니다.
            for (int j = 0; j < N; j++) {
                if (i == j) // 자신과는 비교하지 않습니다.
                    continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    // 만약 자신보다 몸무게와 키가 더 큰 사람이 있다면 등수를 증가시킵니다.
                    rank++;
                }
            }

            sb.append(rank).append(' '); // 결과를 StringBuilder에 추가합니다.
        }
        System.out.println(sb); // 결과 출력
    }
}
