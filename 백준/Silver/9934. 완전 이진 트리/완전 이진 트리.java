import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[(int)Math.pow(2, k) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int size = arr.length;
        int parent = size;
        while (parent != 0) {
            int child = (parent - 1) / 2;
            int gap = (parent - child) * 2;
            for(int i = child; i < size; i += gap){
                sb.append(arr[i] + " ");
            }
            parent = child;
            sb.append("\n");
        }
        System.out.println(sb);
				br.close();
    }
}