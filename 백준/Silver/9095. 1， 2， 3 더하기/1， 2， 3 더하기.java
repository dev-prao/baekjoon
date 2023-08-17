import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[4];
        for (int i = 0 ; i < 4 ; i++) {
            a[i] = i;
        }

        int[] d = new int[11];
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4 ; i < 11 ; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }

        for (int i = 0 ; i < n ; i++) {
            System.out.println(d[sc.nextInt()]);
        }
        sc.close();
    }
}