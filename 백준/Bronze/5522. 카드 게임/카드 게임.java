import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n;
        for(int i = 0; i < 5; i++) {
            n = sc.nextInt();
            sum += n;
        }
        sc.close();
        System.out.print(sum);
    }
}