import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException,IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        long arr[] = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for(int k = 0; k < n; k++) {
            long find = arr[k];
            int start = 0;
            int end = n - 1;
            while(start < end) {
                if(arr[start] + arr[end] == find) {
                    if(start != k && end != k) {
                        result++;
                        break;
                    } else if(start == k) {
                        start++;
                    } else {
                        end--;
                    }
                } else if(arr[start] + arr[end] < find) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}