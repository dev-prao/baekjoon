import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] sumArr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int temp = sc.nextInt();
            if (i == 0) {
                sumArr[i] = temp;
            } else {
                sumArr[i] = sumArr[i - 1] + temp;
            }
        }


        for (int i = 0 ; i < m ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 1) {
                System.out.println(sumArr[b - 1]);
            } else {
                System.out.println(sumArr[b - 1] - sumArr[a - 2]);
            }
        }
        sc.close();
    }
}