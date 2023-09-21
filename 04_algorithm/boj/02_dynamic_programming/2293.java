import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = sToI(st.nextToken());
        int k = sToI(st.nextToken());

        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int value = sToI(reader.readLine());

            for (int j = 1; j <= k; j++) {
                if (j >= value) {
                    dp[j] += dp[j - value];
                }
            }
        }

        System.out.print(dp[k]);
        reader.close();
    }

    static int sToI(String s) {
        return Integer.parseInt(s);
    }
}