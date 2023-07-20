import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BigInteger a = new BigInteger(br.readLine());
            BigInteger b = new BigInteger(br.readLine());
            BigInteger result = a.add(b);
            System.out.println(result.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
