import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static boolean[] prime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		prime = new boolean[1000001];
		
		getPrime();
		
		for (int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int partition1 = N / 2;
			int partition2 = N / 2;
			
			int count = 0;
			while(true) {
				if(!prime[partition1] && !prime[partition2]) {
					count++;
				}
				
				partition1--;
				partition2++;
				
				if(partition1 <= 2 || partition2 <= 2) {
					break;
				}
			}
			System.out.println(count);
		}	
	}
	
	// 소수이면 false
	public static void getPrime() {
		prime[0] = prime[1] = true;
		
		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i]) {
				continue;
			}

			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}