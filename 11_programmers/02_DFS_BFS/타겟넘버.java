/*
dfs 에서 꼭 구현해야 하는 2가지
1. 수행동작 : 재귀함수가 호출 됐을 때 한 턴마다 수행할 동작 구현
2. 탈출조건 : 어느 시점에 이 재귀함수를 끊을지 구현
*/

class Solution {

    // 두 함수에서 사용하기 위해 전역 변수로 선언

    int[] numbers;
    int target;
    int answer;

    // dfs 함수 

    public void dfs(int index, int sum) { // index : numbers 배열의 인덱스, sum : 누적 합

        // 탈출 조건

        if (index == numbers.length) { 
            if (sum == target) answer ++; 
            return;
        }

        // 수행 동작

        dfs(index + 1, sum + numbers[index]); // 더하는 경우 : 누적합에 현재 인덱스 번째 숫자를 더해 다음 dfs 함수 호출
        dfs(index + 1, sum - numbers[index]); // 빼는 경우 : 누적합에 현재 인덱스 번째 숫자를 빼고 다음 dfs 함수 호출
    }

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.target = target;
        answer = 0;

        dfs(0,0); // dfs 함수 호출

        return answer;
    }
}
