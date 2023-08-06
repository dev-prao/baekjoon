import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = {1,0,0};
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int temp = arr[n1-1];
            arr[n1-1] = arr[n2-1];
            arr[n2-1] = temp;
        }
        for (int i = 0 ; i < 3 ; i++) {
            if(arr[i] == 1) System.out.println(i+1);
        }
        br.close();
    }
}