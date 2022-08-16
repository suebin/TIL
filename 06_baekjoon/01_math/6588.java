import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// 소수이면 false, 소수가 아니면 true
	public static boolean[] isPrime = new boolean[1000001]; // n의 크기를 잘 확인하고, 배열의 크기를 지정하자!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		getPrime();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			boolean ok = false; // 소수를 구한다면 true, 소수를 구하지 못했다면 false일 것이다.

			if (n == 0) {
				break;
			}

			for (int i = 3; i <= n/2; i++) {
				if (!isPrime[i] && !isPrime[n - i]) {
					System.out.println(n + " = " + i + " + " + (n - i));
					ok = true;
					break;
				}
			}

			if (!ok) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}

	}

	// 소수 구하기 : 소수이면 false
	public static void getPrime() {

		isPrime[0] = isPrime[1] = true;

		for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {

			if (isPrime[i]) {
				continue;
			}

			for (int j = i * i; j < isPrime.length; j += i) {
				isPrime[j] = true;
			}
		}

	}
}