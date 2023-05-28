import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int num = 0;
            String str = Integer.toString(i);

            for (int j = 0; j < str.length(); j++) {
                num += Character.getNumericValue(str.charAt(j));
            }

            int num_sum = i + num;

            if (num_sum == n) {
                System.out.println(i);
                break;
            }

            if (i == n) {
                System.out.println(0);
            }
        }
    }
}
