import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static StringBuilder ans;
    private static final String[] operation = {" ", "+", "-"};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        ans = new StringBuilder();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(reader.readLine());
            makeExpression(1, "1");
            ans.append("\n");
        }

        System.out.println(ans);
    }

    private static void makeExpression(int num, String expression) {
        if (num == n) {
            if (cal(expression.replaceAll(" ", "")) == 0) {
                ans.append(expression).append("\n");
            }
            return;
        }

        for (String symbol : operation) {
            makeExpression(num + 1, expression + symbol + (num + 1));
        }
    }

    private static int cal(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+|-", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (operation.equals("+")) sum += num;
            else sum -= num;
        }

        return sum;
    }
}