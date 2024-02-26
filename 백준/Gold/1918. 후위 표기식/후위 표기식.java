import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder postfix = new StringBuilder();
		String input = br.readLine();
		Deque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			switch (c) {
				case '+':
				case '-':
				case '*':
				case '/':
					while (!stack.isEmpty() && priority(stack.peekLast()) >= priority(c)) {
						postfix.append(stack.pollLast());
					}
					stack.offer(c);
					break;
				case '(':
					stack.offer(c);
					break;
				case ')':
					while (!stack.isEmpty() && stack.peekLast() != '(') {
						postfix.append(stack.pollLast());
					}
					stack.pollLast();
					break;
				default:
					postfix.append(c);
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pollLast());
		}
		System.out.println(postfix);
	}

	public static int priority(char operator) {
		if (operator == '(' || operator == ')') {
			return 0;
		} else if (operator == '+' || operator == '-') {
			return 1;
		} else if (operator == '*' || operator == '/') {
			return 2;
		}
		return -1;
	}
}
