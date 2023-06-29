import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> workingDays = new LinkedList<>(); // 작업에 걸리는 일 수 저장
        List<Integer> releaseCounts = new ArrayList<>(); // 각 배포마다의 기능 수 저장

        for (int i = 0; i < progresses.length; i++) {
            int days = ((100 - progresses[i]) / speeds[i]);
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days += 1;
            }

            if (!workingDays.isEmpty() && workingDays.peek() < days) {
                releaseCounts.add(workingDays.size());
                workingDays.clear();
            }

            workingDays.offer(days);
        }
        releaseCounts.add(workingDays.size());

        int[] answer = new int[releaseCounts.size()];
        for (int i = 0; i < releaseCounts.size(); i++) {
            answer[i] = releaseCounts.get(i);
        }

        return answer;
    }
}