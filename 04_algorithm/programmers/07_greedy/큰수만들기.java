import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> nums = new Stack<>();
        int size = number.length() - k;

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);

            while (!nums.isEmpty() && nums.peek() < c && k --> 0) {
                nums.pop();
            }
            nums.add(c);
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < size; i++) {
            answer.append(nums.get(i));
        }

        return answer.toString();
    }
}