import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int     x  = in.nextInt(), y = in.nextInt(), w = in.nextInt(), h = in.nextInt();
        in.close();
        int result = Math.min(Math.abs(x - w), Math.abs(y - h));
        result = Math.min(result, x);
        result = Math.min(result, y);

        System.out.println(result);
    }
}