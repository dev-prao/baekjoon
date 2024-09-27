class Solution {
    public int solution(int[] wallet, int[] bill) {
        //1
        int answer = 0;
        //2
        while(true) {
            if((wallet[0] >= bill[0] && wallet[1] >= bill[1])
              || (wallet[1] >= bill[0] && wallet[0] >= bill[1])) {
                  break;
              }
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        
        
        
        
        return answer;
    }
}