import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        while (!priorityQueue.isEmpty()) {
            int locationIdx = 0;
            for (int priority : priorities) {
                if (priority == priorityQueue.peek()) {
                    answer++;
                    if (locationIdx == location) {
                        return answer;
                    }
                    priorityQueue.poll();
                }
                locationIdx++;
            }
        }

        return answer;
    }
}