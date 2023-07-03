class Solution {
    static int targetNumberCnt = 0;

    public int solution(int[] numbers, int target) {
        getTargetNumberCnt(numbers, 0, target, 0);
        int answer = targetNumberCnt;
        return answer;
    }

    static void getTargetNumberCnt(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                targetNumberCnt++;
            }
            return;
        }

        getTargetNumberCnt(numbers, depth + 1, target, sum + numbers[depth]);
        getTargetNumberCnt(numbers, depth + 1, target, sum - numbers[depth]);
    }
}