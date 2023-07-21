import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String result = "";
        switch(n) {
            case "SONGDO": result = "HIGHSCHOOL"; break;
            case "CODE": result = "MASTER"; break;
            case "2023": result = "0611"; break;
            case "ALGORITHM": result = "CONTEST"; break;
        }
        System.out.println(result);
        sc.close();
    }
}