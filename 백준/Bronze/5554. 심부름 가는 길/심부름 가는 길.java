import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        for(int i = 0; i < 4; i++) {
            total += sc.nextInt();
        }
        int m = total / 60;
        int s = total % 60;
        System.out.println(m);
        System.out.println(s);
        sc.close();
    }
}