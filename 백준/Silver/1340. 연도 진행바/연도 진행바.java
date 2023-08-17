import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String sMonth = st.nextToken();
        String tempDay = st.nextToken();
        int day = Integer.parseInt(tempDay.substring(0, tempDay.length() - 1));
        int year = Integer.parseInt(st.nextToken());
        String tempTime = st.nextToken();
        int hour = Integer.parseInt(tempTime.substring(0, 2));
        int minute = Integer.parseInt(tempTime.substring(3, 5));

        br.close();

        int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDay = 365;
        boolean leapYear = false;

        if (year % 400 == 0 || (year % 4 == 0) && (year % 100 != 0)) {
            leapYear     = true;
            totalDay     = 366;
            monthDays[2] = 29;
        }

        HashMap<String, Integer> monthMap = new HashMap<>();
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);

        int month = monthMap.get(sMonth);
        int sumTime = 0;
        for (int i = 1 ; i < month ; i++) {
            sumTime += monthDays[i] * 24 * 60;
        }
        sumTime += (day - 1) * 24 * 60;
        sumTime += hour * 60;
        sumTime += minute;
        int totalTime = totalDay * 24 * 60;

        double answer = ((double) sumTime / totalTime) * 100;
        System.out.println(answer);
    }
}