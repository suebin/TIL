import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] height = new int[n + 1];
        int[] cnt = new int[n + 1];
        int[] closestMinNums = new int[n + 1];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
            closestMinNums[i] = -100000;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            deleteLowBuildings(stack, height, i);
            cnt[i] = stack.size();
            if (cnt[i] > 0) closestMinNums[i] = stack.peek();
            stack.push(i);
        }

        stack.clear();
        for (int i = n; i > 0; i--) {
            deleteLowBuildings(stack, height, i);
            cnt[i] += stack.size();
            if (!stack.isEmpty() && stack.peek() - i < i - closestMinNums[i]) closestMinNums[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            ans.append(cnt[i]);
            if (cnt[i] > 0) ans.append(" ").append(closestMinNums[i]);
            ans.append("\n");
        }

        System.out.print(ans);
    }

    private static void deleteLowBuildings(Stack<Integer> stack, int[] height, int i) {
        while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
            stack.pop();
        }
    }
}