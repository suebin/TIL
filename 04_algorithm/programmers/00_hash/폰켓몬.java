import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int totalPonkemonTypeCnt = numSet.size(); // 총 폰켓몬 종류 개수
        int ponkemonCnt = nums.length / 2; // 가질 수 있는 폰켓몬 개수

        int answer = (totalPonkemonTypeCnt > ponkemonCnt) ? ponkemonCnt : totalPonkemonTypeCnt;
        return answer;
    }
}