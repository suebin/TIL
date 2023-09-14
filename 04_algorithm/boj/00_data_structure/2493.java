import java.util.*;
import java.io.*;

public class Main {
    private static Stack<Top> stack;
    private static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        stack = new Stack<>();
        result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (!stack.isEmpty() && stack.peek().height < height) {
                while (!stack.isEmpty()) {
                    stack.pop();
                    if (check(height)) break;
                }
            } else {
                check(height);
            }

            stack.add(new Top(i, height));
        }

        System.out.print(result);
        reader.close();
    }

    private static boolean check(int height) {
        if (stack.isEmpty()) {
            result.append(0).append(' ');
        } else if (stack.peek().height > height) {
            result.append(stack.peek().num).append(' ');
            return true;
        }

        return false;
    }

    private static class Top {
        int num;
        int height;

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}