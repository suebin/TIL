import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[t + 1][w + 1];

        for (int i = 1; i <= t; i++) {
            int tree = stringToInteger(reader.readLine());

            for (int j = 0; j <= w; j++) {
                if (j == 0) {
                    if (tree == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                    continue;
                }

                if (j % 2 == 0) {
                    if (tree == 1) {
                        dp[i][j] = max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    }
                } else {
                    if (tree == 1) {
                        dp[i][j] = max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                    } else {
                        dp[i][j] = max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
                    }
                }
            }
        }

        int answer = 0;
        for (int cnt : dp[t]) {
            answer = max(cnt, answer);
        }

        System.out.print(answer);
        reader.close();
    }

    static int stringToInteger(String s) {
        return Integer.parseInt(s);
    }

    static int max(int a, int b) {
        return Math.max(a, b);
    }
}