import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= K; j++) {
                if (j < W) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(V + dp[i - 1][j - W], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}