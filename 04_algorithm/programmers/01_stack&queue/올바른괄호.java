import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        stack.pop();
                        break;
                    }
                    answer = false;
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}