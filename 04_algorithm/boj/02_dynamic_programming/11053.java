import java.util.*;
import java.io.*;

public class Main {
    private static int[] arr;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new Integer[n];

        for (int i = 0; i < n; i++) {
            LIS(i);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(dp[i], result);
        }

        System.out.print(result);
        reader.close();
    }

    private static int LIS(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[n] > arr[i]) dp[n] = Math.max(dp[n], LIS(i) + 1);
            }
        }

        return dp[n];
    }
}