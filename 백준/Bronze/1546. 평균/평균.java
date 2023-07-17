import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        int sum = 0;
        int maxNum = 0;
        int numArr[] = new int[n];

        for (int i = 0 ; i < n ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ; i < n ; i++) {
            sum += numArr[i];
            if(numArr[i] > maxNum) {
                maxNum = numArr[i];
            }
        }

        System.out.println((double)sum * 100 / (maxNum*n));
    }
}