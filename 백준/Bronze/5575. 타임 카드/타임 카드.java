import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0 ; i < 3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            if(s1 > s2) {
                s2 -= (s1 - 60);
                m2--;
            } else {
                s2 -= s1;
            }
            if(m1 > m2) {
                m2 -= (m1 - 60);
                h2--;
            } else {
                m2 -= m1;
            }
            h2 -= h1;
            System.out.println(h2 + " " + m2 + " " + s2);
        }
        br.close();
    }
}