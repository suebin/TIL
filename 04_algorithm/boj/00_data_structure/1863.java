import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String[] location = reader.readLine().split(" ");
            int y = Integer.parseInt(location[1]);

            while (!stack.isEmpty() && y < stack.peek()) {
                stack.pop();
                ans++;
            }

            if (!stack.isEmpty() && y == stack.peek()) continue;
            if (y != 0) stack.push(y);
        }

        System.out.print(ans + stack.size());
    }
}