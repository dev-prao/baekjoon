import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Long> storedWires = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            storedWires.add(Long.parseLong(br.readLine()));
        }

        long totalLength = 0;
        for (long wire : storedWires) {
            totalLength += wire;
        }

        // 이진 탐색을 위한 정렬
        Collections.sort(storedWires);

        // 이진 탐색을 통해 maxLength를 찾음
        long low = 1;
        long high = totalLength / n;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = getCount(storedWires, mid);

            if (count >= n) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    private static long getCount(List<Long> wires, long maxLength) {
        long count = 0;
        for (long wire : wires) {
            count += wire / maxLength;
        }
        return count;
    }
}
