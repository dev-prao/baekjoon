import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 첫 번째 수 입력
        br.close();
        int max = 0;
        ArrayList<Integer> maxlist = new ArrayList<Integer>(); // 최대 개수의 숫자 조합을 저장할 리스트

        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> nowlist = new ArrayList<Integer>(); // 현재 경우의 숫자 조합을 저장할 리스트
            nowlist.add(n); // n을 리스트의 1번에, i를 리스트의 2번에 저장해두고 계산을 시작
            nowlist.add(i);
            int prev1 = n;
            int prev2 = i;

            while (true) {
                int temp = prev1 - prev2; // 다음 항을 계산 (앞 앞 숫자에서 앞 숫자를 빼준 값)

                if (temp >= 0) {
                    nowlist.add(temp); // 결과가 0 이상이면 리스트에 추가
                } else {
                    break; // 결과가 음수이면 반복 종료
                }

                prev1 = prev2; // 앞 앞 숫자와 앞 숫자를 갱신
                prev2 = temp;
            }

            if (max < nowlist.size()) { // 이번 회차가 최대 개수의 숫자라면 해당 개수를 max에 저장하고 리스트의 숫자 조합을 maxlist에 저장
                max = nowlist.size();
                maxlist = nowlist;
            }
        }

        System.out.println(max); // 최대 값 출력
        for (int i = 0; i < maxlist.size(); i++) {
            System.out.print(maxlist.get(i) + " "); // 최대 개수의 숫자 조합 출력
        }
    }

}
