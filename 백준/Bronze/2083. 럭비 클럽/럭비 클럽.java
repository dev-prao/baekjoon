import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            String level = "";
            if (name == "#" || age == 0 || weight == 0) break;
            if (age > 17 || weight >= 80) {
                level = "Senior";
            } else {
                level = "Junior";
            }
            System.out.printf("%s %s\n", name, level);
        }
    }
}