import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        int result = calculate(A, B);
        System.out.println(result);
    }
    
    public static int calculate(int A, int B) {
        return (A + B) * (A - B);
    }
}
