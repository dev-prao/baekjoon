import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] seat = new int[n+2]; // 1부터 n까지 인덱스를 사용 -> 0으로 다 대입되어 있는 배열
        for(int i = 1; i < n+1; i++) {
            seat[i] = 1;
        }
        for (int l : lost) {
            seat[l]--; // 1개씩 잃어버린 걸 반영함
        }

        for (int r : reserve) {
            seat[r]++; // 1개의 여분을 반영
        }

        for(int i = 1; i < seat.length - 1; i++) {
            if(seat[i] == 0 && seat[i-1] == 2) {
                seat[i]++;
                seat[i-1]--;
            } else if(seat[i] == 0 && seat[i+1] == 2) {
                seat[i]++;
                seat[i+1]--;
            }
        }
        
        for(int i : seat) {
            if(i >= 1) answer++;
        }
        
        return answer;
    }
}