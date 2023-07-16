import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double result1 = n * 0.78;
        double result2 = n * 0.8 + n * 0.2 * 0.78;
        sc.close();
        System.out.println((int)result1 + " " + (int)result2);
    }
}