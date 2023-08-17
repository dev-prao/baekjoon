import java.util.*;

class Solution {
    // d, l, r, u 순으로 탐색을 위한 방향 배열
    private static final int[] dx = {1, 0, 0, -1};
    private static final int[] dy = {0, -1, 1, 0};
    private static final String[] term = {"d", "l", "r", "u"}; // 각 방향을 나타내는 문자열 배열

    private static int mapX, mapY; // 맵의 가로, 세로 크기
    private static int endX, endY; // 목표 지점의 좌표
    private String tempAnswer = ""; // 임시로 저장할 정답 문자열

    // 깊이 우선 탐색 (Depth-First Search) 메서드
    public boolean dfs(int x, int y, int k, String str, int diff) {
        // 목표 지점까지 이동한 경우
        if (k == 0 && diff == 0) {
            tempAnswer = str; // 정답 문자열 갱신
            return true; // 탐색 종료
        }
        
        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            
            // 다음 위치가 맵 범위 내에 있고, 이동 횟수 제한 내에 있는 경우
            if (nextX >= 0 && nextY >= 0 && nextX < mapX && nextY < mapY && diff <= k) {
                // 이동 거리의 홀/짝성과 남은 이동 횟수의 홀/짝성이 같은 경우에만 이동 가능
                if ((diff % 2 == 0 && k % 2 == 0) || (diff % 2 == 1 && k % 2 == 1)) {
                    // 재귀적으로 다음 위치 탐색
                    if (dfs(nextX, nextY, k - 1, str + term[i], Math.abs(nextX - endX) + Math.abs(nextY - endY))) {
                        return true; // 탐색 종료
                    }
                }
            }
        }
        return false; // 탐색 실패
    }
    
    // 문제의 해결을 위한 메인 메서드
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer;
        mapX = n; // 맵의 가로 크기
        mapY = m; // 맵의 세로 크기
        endX = r - 1; // 목표 지점의 가로 좌표
        endY = c - 1; // 목표 지점의 세로 좌표
        
        // 시작 위치에서 목표 지점까지의 거리 계산
        int diff = Math.abs((r - 1) - (x - 1)) + Math.abs((c - 1) - (y - 1));
        
        // DFS 메서드 호출을 통해 경로 탐색
        dfs(x - 1, y - 1, k, "", diff);
        
        // 결과에 따라 정답 설정
        if (tempAnswer.equals("")) {
            answer = "impossible"; // 경로를 찾지 못한 경우
        } else {
            answer = tempAnswer; // 경로를 찾은 경우
        }
        
        return answer; // 최종 결과 반환
    }
}