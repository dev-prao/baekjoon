import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            char[] cNum = br.readLine().toCharArray();
            if(cNum[0] == '0') break;
            int lengthOfArray = cNum.length;
            int sum = 1;
            for (int i = 0 ; i < lengthOfArray ; i++) {
                sum++; //사이 간격
                if(cNum[i] == '1') {
                    sum += 2;
                } else if (cNum[i] == '0') {
                    sum += 4;
                } else {
                    sum += 3;
                }
            }
            System.out.println(sum);
        }
        br.close();
    }
}