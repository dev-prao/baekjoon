import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(arithmetic_sequence(num));
    }

    public static int arithmetic_sequence(int num) {
        int cnt = 0; //한수 카운팅

        if (num < 100) {
            return num;
        } else {
            cnt = 99;

            for (int i = 100 ; i <= num ; i++) {
                int hundred = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;
                if((hundred - ten) == (ten - one)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}