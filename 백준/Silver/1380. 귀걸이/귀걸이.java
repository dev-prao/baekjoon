import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int scenario = 0; // 현재 시나리오 번호
        
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return; // 입력이 0일 경우 종료
            } else {
                scenario++;
            }

            ArrayList<String> girls = new ArrayList<>(); // 여학생 이름을 저장할 리스트

            // 여학생들의 이름 입력
            for (int i = 0; i < n; i++) {
                girls.add(br.readLine());
            }

            ArrayList<Integer> lostEarrings = new ArrayList<>(); // 귀걸이를 잃어버린 학생 번호를 저장할 리스트
            
            // 여학생들의 귀걸이 상태 입력
            for (int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (lostEarrings.contains(num)) {
                    lostEarrings.remove((Integer) num); // 귀걸이를 되돌려받은 경우
                } else {
                    lostEarrings.add(num); // 처음 잃어버린 경우
                }
            }

            int lostGirlIndex = lostEarrings.get(0); // 귀걸이를 잃어버린 학생의 번호
            
            // 결과 출력
            System.out.println(scenario + " " + girls.get(lostGirlIndex - 1));
        }
    }
}
