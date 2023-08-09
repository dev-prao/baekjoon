class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] cs = s.toCharArray();
        int n = s.length();
        int cp = 0;
        int cy = 0;
        for (int i = 0 ; i < n ; i++) {
            if(cs[i] == 'p' || cs[i] == 'P') {
                cp++;
            } else if (cs[i] == 'y' || cs[i] == 'Y') {
                cy++;
            }
        }
        
        if(cp == cy) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}