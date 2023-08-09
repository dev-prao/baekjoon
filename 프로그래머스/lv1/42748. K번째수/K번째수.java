import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int a = 0 ; a < commands.length ; a++) {
            int i = commands[a][0] - 1;
            int j = commands[a][1] - 1;
            int k = commands[a][2] - 1;

            int[] newArr = new int[j - i + 1];
            int idx = 0;
            for (int l = i ; l <= j ; l++) {
                newArr[idx] = array[l];
                idx++;
            }
            Arrays.sort(newArr);
            answer[a] = newArr[k];
        }
        return answer;
    }
}