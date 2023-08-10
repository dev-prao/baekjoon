import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1 ; i <= n ; i++) {
            queue.add(i);
        }

        System.out.print("<");
        while(!queue.isEmpty()) {
            for (int i = 1 ; i <= k ; i++) {
                if(i==k) {
                    int num = queue.poll();
                    if(queue.isEmpty()) {
                        System.out.print(num + ">");
                    } else {
                        System.out.print(num + ", ");
                    }
                } else {
                    queue.add(queue.poll());
                }
            }
        }
        br.close();
    }
}