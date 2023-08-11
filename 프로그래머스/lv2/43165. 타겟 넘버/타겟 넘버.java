import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0; //방법의 개수
        
        Queue<ArrayList<Integer>> q = new ArrayDeque<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0); //깊이
        list.add(0); //합
        q.add(list);
        while(!q.isEmpty()) {
            ArrayList<Integer> el = q.poll(); //가장 오래된 요소 뽑기
            int depth = el.get(0);
            int sum = el.get(1);
            if(depth < numbers.length) { //el[0] -> depth, el[1] -> sum
                //0번째의 깊이가 numbers.length와 같게 되면 멈춘다.
                //el.get(0) < numbers.length -> 아직 끝까지 탐색하지 않았을 때
                ArrayList<Integer> plus = new ArrayList<>();
                //numbers[depth] -> 이번 깊이에서 확인할 숫자(+,-)
                plus.add(depth + 1);
                plus.add(sum + numbers[depth]);
                q.add(plus); //+노드로 갈 경우
                ArrayList<Integer> minus = new ArrayList<>();
                //numbers[depth] -> 이번 깊이에서 확인할 숫자(+,-)
                minus.add(depth + 1);
                minus.add(sum - numbers[depth]);
                q.add(minus); //-노드로 갈 경우
            } else { //아닐 경우 끝까지 탐색 완료
                //depth가 끝까지 옴 -> sum == target일시 answer++
                answer += sum == target ? 1 : 0;
            }
        }
        return answer;
    }
}