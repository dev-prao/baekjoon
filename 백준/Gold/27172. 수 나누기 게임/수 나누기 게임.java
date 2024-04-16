import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
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
            System.out.print(ans[arr[i]] + " ");
        }
    }

}