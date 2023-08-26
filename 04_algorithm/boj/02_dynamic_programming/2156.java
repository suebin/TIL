import java.io.*;

public class Main {
    private static int[] wines;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        wines =  new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = 0;
        dp[1] = wines[1];
        if (n >= 2) dp[2] = wines[1] + wines[2];

        System.out.println(find(n));
        reader.close();
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(find(n - 2),  find(n - 3) + wines[n - 1]) + wines[n], find(n - 1));
        }

        return dp[n];
    }
}