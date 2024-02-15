import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] nums = reader.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char now = nums[i];

            while (!stack.isEmpty() && stack.peek() < now && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(now);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        System.out.print(ans.reverse());
    }
}