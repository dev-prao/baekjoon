import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arrN = new int[n][m];
        int[][] arrM = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                arrN[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < m ; j++) {
                arrM[i][j] = Integer.parseInt(st.nextToken());
                arrN[i][j] += arrM[i][j];
            }
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                System.out.print(arrN[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
    }
}


