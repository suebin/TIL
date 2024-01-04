import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(reader.readLine());

            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] dp = new int[n + 1][h + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= h; j++) {
                for (int l : list[i]) {
                    if (j >= l) {
                        dp[i][j] += dp[i - 1][j - l];
                        dp[i][j] %= 10007;
                    }
                }

                dp[i][j] += dp[i - 1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.print(dp[n][h]);
    }
}