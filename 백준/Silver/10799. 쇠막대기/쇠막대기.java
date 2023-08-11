import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();
        for (int i = 0 ; i < arr.length ; i++) {
            char x = arr[i];
            if (x == '(') {
                stack.push(x);
            } else {
                char prev = arr[i - 1];
                if (prev == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}