import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력으로 받는 정사각형의 크기
        int n = Integer.parseInt(br.readLine());

        // 입력된 문자열을 저장하는 2차원 배열
        char[][] arr = new char[n][n];

        // 입력을 받아서 2차원 배열에 저장
        for (int i = 0; i < n; i++) {
            String[] val = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = val[j].charAt(0);
            }
        }

        // 가로 방향과 세로 방향으로 연속된 '.'의 개수를 세는 변수 초기화
        int horizontal = 0;
        int vertical = 0;

        // 모든 배열 요소를 탐색하면서 연속된 '.'의 개수를 센다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && (arr[i][j] == '.' && arr[i][j + 1] == '.' && (j + 2 >= n || arr[i][j + 2] == 'X'))) {
                    // 가로 방향으로 연속된 '.'을 발견할 때 horizontal 변수 증가
                    horizontal++;
                }
                if (i + 1 < n && (arr[i][j] == '.' && arr[i + 1][j] == '.' && (i + 2 >= n || arr[i + 2][j] == 'X'))) {
                    // 세로 방향으로 연속된 '.'을 발견할 때 vertical 변수 증가
                    vertical++;
                }
            }
        }

        // 결과 출력
        System.out.println(horizontal + " " + vertical);
    }
}
