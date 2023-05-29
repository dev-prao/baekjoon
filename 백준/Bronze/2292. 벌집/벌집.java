import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int            n  = Integer.parseInt(br.readLine()), honeycomb = 1, cnt = 1;
        while (n > honeycomb) {
            honeycomb += 6 * cnt;
            cnt++;
        }
        System.out.println(cnt);
    }
}