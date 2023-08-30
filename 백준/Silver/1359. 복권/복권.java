import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 배열과 변수 선언
    private static int[] nums;          // 숫자 배열
    private static int N, M, K;         // N: 전체 숫자 범위, M: 조합 길이, K: 최소 일치 개수
    private static List<String> lottoList = new ArrayList<>();   // 조합 결과를 저장할 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());   // 전체 숫자 범위
        M = Integer.parseInt(tokenizer.nextToken());   // 조합 길이
        K = Integer.parseInt(tokenizer.nextToken());   // 최소 일치 개수

        // 1부터 N까지의 숫자 배열 초기화
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        // 조합 생성 함수 호출
        combination(0, 0, new StringBuilder());

        // 생성된 조합의 개수와 일치 조합을 세는 변수 초기화
        int size = lottoList.size();
        int totalCnt = 0;

        // 모든 조합 쌍을 비교하여 일치 개수가 K 이상인 경우를 세기
        for (String temp : lottoList) {
            for (String s : lottoList) {
                int cnt = 0;
                for (int k = 0; k < M; k++) {
                    if (s.contains(temp.charAt(k) + "")) cnt++;
                }

                if (cnt >= K) totalCnt++;
            }
        }

        // 결과 출력
        System.out.println((double) totalCnt / (size * size));
    }

    // 조합 생성 함수
    private static void combination(int start, int cnt, StringBuilder sb) {
        if (cnt == M) {   // 조합 길이에 도달한 경우 결과를 리스트에 추가하고 종료
            lottoList.add(sb.toString());
            return;
        }

        // 조합 생성을 위한 반복문
        for (int i = start; i < N; i++) {
            int temp = sb.length();
            sb.append(nums[i]);   // 숫자 추가
            combination(i + 1, cnt + 1, sb);   // 재귀 호출로 다음 숫자 선택
            sb.setLength(temp);   // 추가한 숫자 제거 (백트래킹)
        }
    }
}
