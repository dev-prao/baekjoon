import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start_idx = 1;
        int end_idx = 1;
        int sum = 1;
        int cnt = 1;

        while(end_idx != n) {
            if (sum == n) {
                cnt++;
                end_idx++;
                sum += end_idx;
            } else if (sum < n) {
                end_idx++;
                sum += end_idx;
            } else {
                sum -= start_idx;
                start_idx++;
            }
        }
        System.out.println(cnt);


    }
}