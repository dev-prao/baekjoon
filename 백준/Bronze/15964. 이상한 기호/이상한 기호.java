import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextInt();
        long B = sc.nextInt();
        sc.close();
        if(A <= 1000 && B <= 1000) {
            System.out.println((A+B)*(A-B));
        }
        else {
            System.out.println("잘못된 값을 입력하였습니다.");
        }
        
    }
}