import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    // 좌표를 나타내는 클래스
    class Position {
        int x, y;

        // 생성자
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 두 좌표 사이의 거리 계산 메서드
    private long calculateDistance(Position p1, Position p2) {
        return 1L * (p1.x - p2.x) * (p1.x - p2.x) + 1L * (p1.y - p2.y) * (p1.y - p2.y);
    }

    // 문제 해결 메서드
    private void solve() throws Exception {
        int testCaseCount = nextInt(); // 테스트 케이스 개수 입력
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 생성

        // 각 테스트 케이스에 대하여 반복
        while (testCaseCount-- > 0) {
            Position[] positions = new Position[4]; // 4개의 좌표를 저장할 배열 생성
            for (int i = 0; i < 4; i++) {
                positions[i] = new Position(nextInt(), nextInt()); // 좌표 정보 입력
            }

            long[] distances = new long[6]; // 거리를 저장할 배열 생성
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = i + 1; j < 4; j++) {
                    distances[idx++] = calculateDistance(positions[i], positions[j]); // 거리 계산 후 배열에 저장
                }
            }

            Arrays.sort(distances); // 거리 배열을 오름차순으로 정렬
            
            // 모든 거리가 같은 경우 직사각형이므로 1, 아닌 경우 0을 결과에 추가
            if (distances[0] == distances[1] && distances[1] == distances[2] &&
                distances[2] == distances[3] && distances[4] == distances[5]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append('\n'); // 개행문자 추가
        }

        System.out.print(sb); // 결과 출력
    }

    // 메인 메서드
    public static void main(String[] args) throws Exception {
        initInput(); // 입력 초기화
        new Main().solve(); // 문제 해결 메서드 호출
    }

    // 입력 처리를 위한 상수 및 변수
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int curIdx, maxIdx;

    // 입력 초기화
    private static void initInput() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        curIdx = maxIdx = 0;
    }

    // 다음 정수를 입력받는 메서드
    private static int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = (c == '-');
        if (neg) c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg) return -ret;
        return ret;
    }

    // 입력 스트림으로부터 바이트를 읽는 메서드
    private static byte read() throws IOException {
        if (curIdx == maxIdx) {
            maxIdx = inputStream.read(buffer, curIdx = 0, DEFAULT_BUFFER_SIZE);
            if (maxIdx == -1) buffer[0] = -1;
        }
        return buffer[curIdx++];
    }
}
