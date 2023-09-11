import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long result = 0;

        // 문자열을 숫자로 변환 및 모듈로 연산을 사용하여 최적화
        for (int i = 0; i < input.length(); i++) {
            char digitChar = input.charAt(i);
            int digit = digitChar - '0'; // 문자를 숫자로 변환 ('0'을 빼주면 정수로 변환)

            // 현재 결과에 10을 곱하고 입력된 숫자를 더한 후 20000303으로 나눔
            result = (result * 10 + digit) % 20000303;
        }

        System.out.println(result);
    }
}
