import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Integer[] dp; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); 

		dp = new Integer[N+1];
		
		dp[0] = dp[1] = 0;
		
		System.out.print(recur(N));
	}
	
	static int recur(int N) {
		
		if (dp[N] == null) {
			// 6으로 나누어지는 경우
			if (N % 6 == 0) { 
				dp[N] = Math.min(recur(N-1), Math.min(recur(N/3), recur(N/2))) + 1;
			}
			// 3으로만 나누어지는 경우
			else if (N % 3 == 0) {
				dp[N] = Math.min(recur(N/3), recur(N-1)) + 1;
			}
			// 2으로만 나누어지는 경우
			else if (N % 2 == 0) {
				dp[N] = Math.min(recur(N/2), recur(N-1)) + 1;
			}
			// 2와 3으로 나누어지지 않는 경우
			else {
				dp[N] = recur(N-1) + 1;
			}
		}
		
		return dp[N];
	}
	
	/*
	 * 32번째 줄에 "Math.min(recur(N-1), recur(N/3))", 36번째 줄에 "Math.min(recur(N-1)recur(N/2))" 이라고 변수 자리만 바꾸었는데 시간초과가 나는 이유는 ?
	 * 
	 * 자바 함수 호출은 depth가 깊어질수록 비효율적이다. 
	 * n-1을 먼저 호출하면 100만 입력되면 재귀 깊이가 100만이 된다.
	 * 하지만 n/3이나 n/2가 먼저 호출되면 빠르게 1까지 도달하기 때문에 크게 깊어지지 않는다.
     * 
	 * (출처: https://www.acmicpc.net/board/view/95505)
	 * 
	 * */

}