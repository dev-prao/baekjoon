import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //입력받은 숫자(문자열로 저장)
        int[] numArr = new int[str.length()]; //숫자를 넣을 배열

        //배열에 숫자의 각 자리수를 정수형으로 변환하여 대입
        for (int i = 0 ; i < str.length() ; i++) {
            numArr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        //내림차순 정렬(선택 정렬)
        for (int i = 0 ; i < str.length() ; i++) {
            int max = i; //최댓값의 인덱스를 i로 초기화
            
            //i+1부터 끝까지 탐색하며 최댓값 찾기
            for (int j = i + 1 ; j < str.length() ; j++) {
                if (numArr[j] > numArr[max]) { //max보다 큰 값이 있으면 그 값을 max로 변경
                    max = j;
                }
            }
            if (numArr[i] < numArr[max]) { //numArr[max]가 numArr[i]보다 크면 수의 위치 변경
                int temp = numArr[i];
                numArr[i] = numArr[max];
                numArr[max] = temp;
            }
        }

        //내림차순으로 출력
        for (int i = 0 ; i < str.length() ; i++) {
            System.out.print(numArr[i]);
        }
        sc.close();
    }
}