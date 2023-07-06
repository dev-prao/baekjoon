import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sSum = 0;
        int maxNum = 0;
        int sArr[] = new int[N];
        for (int i = 0 ; i < N ; i++) {
            sArr[i] = Integer.parseInt(st.nextToken());
            if (sArr[i] > maxNum) {
                maxNum = sArr[i];
            }
            sSum += sArr[i];
        }
        System.out.println(sSum * 100.0 / (maxNum * N));

    }
}