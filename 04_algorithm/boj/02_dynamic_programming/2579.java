import java.io.*;

public class Main {
    private static int[] scores;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        scores = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1 ; i <= n; i++) {
            scores[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = 0;
        dp[1] = scores[1];

        if (n >= 2) dp[2] = scores[1] + scores[2];

        System.out.print(findMaxValue(n));
        reader.close();
    }

    private static int findMaxValue(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(findMaxValue(n -2), findMaxValue(n - 3) + scores[n - 1]) + scores[n];
        }

        return dp[n];
    }
}