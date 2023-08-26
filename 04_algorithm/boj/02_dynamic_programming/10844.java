import java.io.*;

public class Main {
    private static Long[][] dp;
    private static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        dp = new Long[n + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1L;
        }

        long result = 0;

        for (int i = 1; i <= 9; i++) {
            result += find(n, i);
        }

        System.out.print(result % MOD);
        reader.close();
    }

    private static Long find(int n, int i) {
        if (n == 1) return dp[n][i];

        if (dp[n][i] == null) {
            if (i == 0) {
                dp[n][i] = find(n - 1, 1);
            } else if (i == 9) {
                dp[n][i] = find(n - 1, 8);
            } else {
                dp[n][i] = find(n - 1, i - 1) + find(n - 1, i + 1);
            }
        }

        return dp[n][i] % MOD;
    }
}