import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] card = new boolean[1000001];
        int[] ans = new int[1000001];
        for(int i=0; i<N; ++i) {
            card[arr[i]] = true;
        }

        for(int i : arr) {
            for(int j=i+i; j<1000001; j+=i) {
                if(card[j]) {
                    ++ans[i];
                    --ans[j];
                }
            }
        }
        
        for(int i=0; i<N; ++i) {
            sb.append(ans[arr[i]]).append(" ");
        }
        
        System.out.println(sb);
    }

}