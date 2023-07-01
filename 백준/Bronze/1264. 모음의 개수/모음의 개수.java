import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            int count = 0;
            if(str.equals("#")) {
                break;
            }

            str = str.toLowerCase();

            for(int i = 0; i < str.length(); i++) {
                switch (str.charAt(i)) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        count++;
                    default:
                        break;
                }
            }
            System.out.println(count);
        }

    }
}