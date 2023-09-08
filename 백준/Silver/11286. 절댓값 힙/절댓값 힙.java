import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            
            if(firstAbs == secondAbs) {
                return o1 > o2 ? 1 : -1;
            }
            return firstAbs - secondAbs;
        });
        
        for(int i = 0; i < n; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0 && queue.isEmpty()) {
                System.out.println("0");
            }
            if(request == 0 && !queue.isEmpty()) {
                System.out.println(queue.poll());
            }
            if(request != 0) {
                queue.add(request);
            }
        }
    }
}