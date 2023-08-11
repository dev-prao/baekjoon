import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1 ; i <= n ; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
    }
}