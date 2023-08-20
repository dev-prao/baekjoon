class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length]; // 배열 생성
        
        for (int i = 0; i < strlist.length; i++) { // length() 메서드 대신 length 속성 사용
            answer[i] = strlist[i].length();
        }
        
        return answer;
    }
}
