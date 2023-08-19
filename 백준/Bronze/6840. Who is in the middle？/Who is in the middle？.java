import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> bearBowlList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++) {
            int bowl = scanner.nextInt();
            bearBowlList.add(bowl);
        }
        
        System.out.println(whoIsInTheMiddle(bearBowlList));
    }
    
    public static int whoIsInTheMiddle(List<Integer> bearBowlList) {
        Collections.sort(bearBowlList);
        return bearBowlList.get(1);
    }
}
