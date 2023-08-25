import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine()); // 테스트 케이스 진행 횟수

        ArrayList<Point> pointsList = new ArrayList<>(); // points 리스트를 반복문 밖에서 선언

        for (int i = 0; i < testCaseCount; i++) {
            // 한 테스트 케이스마다 4개의 점 정보 입력
            for (int j = 0; j < 4; j++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                pointsList.add(new Point(x, y));
            }

            pointsList.sort(new PointComparator()); // 정렬 기준을 활용하여 내림차순 정렬

            // 각 점의 좌표 추출
            int x0 = pointsList.get(0).x;
            int x1 = pointsList.get(1).x;
            int x2 = pointsList.get(2).x;
            int x3 = pointsList.get(3).x;

            int y0 = pointsList.get(0).y;
            int y1 = pointsList.get(1).y;
            int y2 = pointsList.get(2).y;
            int y3 = pointsList.get(3).y;

            // 점 간의 거리 제곱 계산
            int powD01 = (int) (Math.pow(x0 - x1, 2) + Math.pow(y0 - y1, 2));
            int powD02 = (int) (Math.pow(x0 - x2, 2) + Math.pow(y0 - y2, 2));
            int powD13 = (int) (Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
            int powD23 = (int) (Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
            int powD12 = (int) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

            // 직사각형 여부 판단
            boolean isRectangle = powD12 == powD01 + powD02;

            // 직사각형이면서 네 변의 길이가 모두 같은지 검사
            if (isRectangle && (powD01 == powD02) && (powD02 == powD13) && (powD13 == powD23)) {
                System.out.println(1); // 직사각형이면서 네 변의 길이가 모두 같을 경우
            } else {
                System.out.println(0); // 직사각형이 아닐 경우
            }

            pointsList.clear(); // 다음 테스트 케이스를 위해 리스트 초기화
        }
    }

    // 좌표를 저장하는 클래스
    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    // 점을 내림차순으로 정렬하기 위한 Comparator 구현
    private static class PointComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            if (p1.x != p2.x) {
                return p2.x - p1.x;
            } else {
                return p2.y - p1.y;
            }
        }
    }
}
