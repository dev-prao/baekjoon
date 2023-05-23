import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Scanner 객체 생성
        int[] inputs = new int[8];  // 크기가 8인 정수형 배열 생성
        for (int i = 0; i < inputs.length; i++) {  // inputs 배열에 값 입력
            inputs[i] = sc.nextInt();  // 사용자로부터 정수 입력 받음
        }
        sc.close();  // Scanner 객체 닫기

        String output = "";  // 출력 결과를 저장할 문자열 변수 초기화
        for (int i = 0; i < inputs.length - 1; i++) {  // 배열을 순회하면서 비교
            if (inputs[i] == inputs[i + 1] - 1) {  // 현재 값이 다음 값보다 1 작으면
                output = "ascending";  // "ascending"으로 출력 설정
            } else if (inputs[i] == inputs[i + 1] + 1) {  // 현재 값이 다음 값보다 1 크면
                output = "descending";  // "descending"으로 출력 설정
            } else {  // 그 외의 경우
                output = "mixed";  // "mixed"로 출력 설정
                break;  // 반복문 종료
            }
        }
        System.out.println(output);  // 결과 출력
    }
}