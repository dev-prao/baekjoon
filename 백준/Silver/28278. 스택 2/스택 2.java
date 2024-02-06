import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); // 출력의 시간을 줄이기 위해 한 번에 출력
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "1":
                    int X = Integer.parseInt(command[1]);
                    stack.push(X);
                    break;
                case "2": sb.append(!stack.isEmpty() ? stack.pop() + "\n" : -1 + "\n"); break;
                case "3": sb.append(stack.size()+"\n"); break;
                case "4": sb.append(stack.isEmpty() ? 1 + "\n" : 0 + "\n"); break;
                case "5": sb.append(!stack.isEmpty() ? stack.peek() + "\n" : -1 + "\n"); break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}