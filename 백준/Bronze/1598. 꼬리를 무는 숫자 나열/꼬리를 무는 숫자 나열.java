import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] resultA = Coordinate(a);
        int[] resultB = Coordinate(b);
        System.out.println(Math.abs(resultB[0] - resultA[0]) + Math.abs(resultB[1] - resultA[1]));

        br.close();
    }

    public static int[] Coordinate(int n) {
        int x;
        int y;
        if (n % 4 == 0) {
            x = n / 4;
            y = 4;
        } else {
            x = (n / 4) + 1;
            y = n % 4;
        }
        int[] result = {x, y};
        return result;
    }
}

