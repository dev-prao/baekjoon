import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 사용자로부터 순번 N을 입력받음
        br.close(); // BufferedReader를 닫음
        
        int startNum = 666; // 영화 제목의 시작 숫자
        int titleRank = 0; // 영화 제목의 순번을 나타내는 변수
        
        while (true) {
            String strNum = String.valueOf(startNum); // 현재 숫자를 문자열로 변환
            
            // 숫자에서 연속된 '666'이 있는지 검사
            for (int i = strNum.length() - 1; i >= 2; i--) {
                if (strNum.charAt(i) == '6' && strNum.charAt(i - 1) == '6' && strNum.charAt(i - 2) == '6') {
                    titleRank++; // '666'이 연속으로 나오면 순번을 증가시킴
                    break; // 한 번의 '666'만 세도록 하기 위해 루프 종료
                }
            }
            
            if (titleRank == N) {
                System.out.println(strNum); // 원하는 순번에 해당하는 영화 제목 출력
                break; // 목표를 달성하면 루프 종료
            }
            
            startNum++; // 다음 숫자로 이동
        }
    }
}
