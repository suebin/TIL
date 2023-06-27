/* int와 long 사용에 신경을 쓰자! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int mod = 1000000009;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int T = Integer.parseInt(br.readLine());

		long[][] dp = new long[100001][4];

		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
			dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
			dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			long result = (dp[n][1] + dp[n][2] + dp[n][3]) % mod;
			sb.append(result).append('\n');
		}

		System.out.println(sb);

	}
}