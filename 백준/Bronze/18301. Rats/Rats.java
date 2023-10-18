import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력 받기
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n12 = scanner.nextInt();

        // Chapman 추정자 N 계산
        int N = ((n1 + 1) * (n2 + 1) / (n12 + 1)) - 1;

        // 결과 출력
        System.out.println(N);
        
        scanner.close();
    }
}
