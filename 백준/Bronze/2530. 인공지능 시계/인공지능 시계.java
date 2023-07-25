import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 현재 시각 입력 받기
        int A = sc.nextInt(); // 시
        int B = sc.nextInt(); // 분
        int C = sc.nextInt(); // 초

        // 요리하는 데 필요한 시간 입력 받기
        int D = sc.nextInt(); // 초

        // 요리하는 데 필요한 시간을 현재 시각에 더함
        C += D;
        B += C / 60; // 분에 더해주고
        C %= 60;    // 초는 60으로 나눈 나머지 값으로 갱신

        A += B / 60; // 시에 더해주고
        B %= 60;    // 분은 60으로 나눈 나머지 값으로 갱신

        A %= 24;    // 시가 24를 넘는 경우 24로 나눈 나머지 값으로 갱신

        // 결과 출력
        System.out.printf("%d %d %d", A, B, C);

        sc.close();
    }
}
