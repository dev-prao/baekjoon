import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line, x, numerator, denumerator;
        x = sc.nextInt();
        line = 1;
        sc.close();

        while(line < x) {
            x -= line;
            line++;
        }

        if (line % 2 == 0) {
            numerator = x;
            denumerator = line - x + 1;
        } else {
            numerator = line - x +1;
            denumerator = x;
        }

        System.out.printf("%d/%d",numerator,denumerator);
    }
}