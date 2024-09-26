import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int n = order.length;
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            if (i == order[answer]) {
                answer++;
                continue;
            } 
            
            if (!q.isEmpty() && q.peekLast() == order[answer]) {
                q.pollLast();
                answer++;
                i--;
                continue;
            }
            
            q.offerLast(i);
        }
        
        while (!q.isEmpty() && q.peekLast() == order[answer]) {
            q.pollLast();
            answer++;
        }
        
        return answer;
    }
}
