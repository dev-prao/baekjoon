class Solution {
    int answer = 0; //멤버변수 -> Solution 내부에서 쓸 수 있게
    //타겟 넘버를 만드는 방법의 수 (dfs로 탐색했을 때 총합이 타겟 넘버와 같다면...)
    int target; //멤버변수, 매개변수로 전달받은 타겟 넘버를 저장
    int numbers[]; //멤버변수, 전달받은 숫자(입력값)
    
    public int solution(int[] numbers, int target) {
        //1. 깊이 우선 탐색(DFS): 재귀함수
        this.numbers = numbers; //숫자 목록
        this.target = target; //매개변수 인자 -> this.멤버변수로 이동
        //+,-를 해서 구할 숫자(마지막 노드까지 계산해서 나와야 할 값)
        
        //제공받은 numbers의 길이만큼(depth) 반복해서 노드 탐색
        dfs(0, 0); //0인 깊이, 0인 합 -> dfs 탐색(재귀) 진행
        
        return answer;
    }
    
    //dfs가 별도의 메서드이기 때문에 solution에서의 입력값(매개변수)를 직접 사용할 수 없음.
    public void dfs(int depth, int sum) { //depth가 1씩 증가
        //sum -> 현재까지 모두 더해준 값(target 변수)
        //다음 dfs를 호출할 때 깊이와 현재까지의 합
        // System.out.println(depth + " " + sum);
        //1: + 노드로 이동
        //2: - 노드로 이동
        //3: 더이상 탐색할 노드가 없음
        if(depth < numbers.length) { //아직 탐색할 노드가 남아있음
            //numbers.length = 마지막 인덱스 + 1(길이 = 마지막 인덱스 + 1)
            dfs(depth + 1, sum + numbers[depth]);
            //1. + 노드로 이동시 현 depth 위치의 숫자를 더한다.
            dfs(depth + 1, sum - numbers[depth]);
            //2. - 노드로 이동시 현 depth 위치의 숫자를 뺀다.
        } else { //depth == numbers.length -> 더이상 탐색할 노드가 남아있지 않음
            //마지막까지 왔음
            //모든 연산이 끝났을 때 sum이 target과 일치하는지 확인
            if(sum == target) {
                answer++;
            }
        }
    }
}