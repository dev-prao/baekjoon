import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine()); // 문자열의 길이를 입력받습니다.
        String string = br.readLine(); // 문자열을 입력받습니다.
        br.close();

        // hashFunction 메서드를 호출하여 해시 값을 계산하고 출력합니다.
        System.out.println(hashFunction(length, string));
    }

    public static int hashFunction(int length, String string) {
        List<Integer> list = new ArrayList<>(); // 문자열의 각 문자를 숫자로 변환하여 저장할 리스트를 생성합니다.
        int result = 0; // 최종 해시 값을 저장할 변수를 초기화합니다.

        // 문자열의 각 문자를 숫자로 변환하여 리스트에 저장합니다.
        for (int i = 0; i < length; i++) {
            list.add(string.charAt(i) - 96); // 알파벳 소문자 'a'의 ASCII 값인 97을 뺌으로써 'a'를 1로, 'b'를 2로 매핑합니다.
        }

        // 해시 값을 계산합니다.
        for (int i = 0; i < length; i++) {
            int counter = 1; // 지수 값 계산을 위한 변수를 초기화합니다.
            for (int j = 0; j < i; j++) {
                counter *= 31; // 31의 제곱 값을 계산하여 지수를 증가시킵니다.
            }
            result += (list.get(i) * counter) % 1234567891; // 문자 숫자와 지수를 곱한 뒤, 모듈러 연산을 통해 해시 값을 누적합니다.
        }

        return result; // 최종 해시 값을 반환합니다.
    }
}
