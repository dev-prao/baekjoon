// 효율성 통과용
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> pMap = new HashMap<>();
        for (String p : participant) {
            int prevCount = pMap.getOrDefault(p, 0);
            pMap.put(p, prevCount + 1);
        }
        for (String c : completion) {
            if (pMap.get(c) == 1) { // 완주한 선수명 -> 참가선수맵
                pMap.remove(c); // 참가자 명단에서 더 이상 그 이름이 없음
            } else {
                pMap.put(c, pMap.get(c) - 1); // 1명 제거
            }
        }
        for (String key : pMap.keySet()) {
            return key; // 1개 밖에 없으니까...
        }
        return "";
    }
}