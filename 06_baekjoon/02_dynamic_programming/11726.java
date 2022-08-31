public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+2];
    
    dp[1] = 1;
    dp[2] = 2;
    
    for(int i=3; i<=N; i++) {
        dp[i] = (dp[i-1] + dp[i-2])%10007;
    }
    
    System.out.println(dp[N]);
    
    /*
     * mod 연산을 한 결과값을 출력해야 할 때에는 반드시 연산할 때마다 mod 연산을 해주어야 한다. 
     * 계속 숫자를 더하고 마지막 출력 시에만 mod 연산을 해줄 경우
     * Integer.MAX_VALUE를 넘어 Overflow가 발생하기 때문에 잘못된 값이 출력될 수 있다.
     * (참고: https://girawhale.tistory.com/33)
     */
    }
}