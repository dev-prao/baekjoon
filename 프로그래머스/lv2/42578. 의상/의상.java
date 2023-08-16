import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            // i = 0 : 각기 옷의 이름
            // i = 1 : 옷의 종류 (겹치면 안됨)
            // map.put(c[1], 1);
            // 같은 카테고리는 key를 통해서 한 번만 저장...
            // 이미 카테고리가 저장이 되어 있다면, +1을 해주고,
            // 없다면 1을 대입해주는 조건
            // if (map.containsKey(c[1])) {
            //     // 있다는 것은, 이미 1이 put 되어 있다는 의미이므로
            //     map.put(c[1], map.get(c[1]) + 1);    
            //     // +1한 값으로 재대입(재할당, 수정)
            //     // map을 통해서 특정한 값을 세는 방법
            // } else {
            //     map.put(c[1], 1); // 없으면 null 나오니까
            //     // 안정적으로 put
            // }
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
            
        }
        System.out.println(map); // 각각의 옷의 종류를 key.
        System.out.println(map.values());
        // 가짓수 -> 각각의 항목
        int answer = 1;
        for(int v : map.values()) {
            answer *= (v + 1);
        }
        
        answer -= 1;
        return answer;
    }
}