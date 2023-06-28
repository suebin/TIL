import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		// GCD (Greatest Common Divisor)
		int g = gcd(a, b);
				
		System.out.println(g);
		
		// LCM (Least Common Multiple)
		System.out.println((a*b)/g);
		
		
	}
	// 재귀 (유클리드 호제법)
	public static int gcd(int a, int b) {
		if (b == 0) return a;
		
		return gcd(b, a % b);
	}
}	