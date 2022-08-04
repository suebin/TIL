import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		String s = br.readLine();

		// 피연산자의 개수만큼 피연산자에 대응하는 값인 숫자를 배열에 저장
		double[] arr = new double[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		Stack<Double> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			
			// 1. now가 피연산자일때
			
			// A의 아스키코드는 65이다. now가 65 이상이면 영대문자이다.
			if (now >= 65) {
				// 피연산자(영대문자)는 대응하는 값을 배열에서 찾아 스택에 넣기
				stack.push(arr[s.charAt(i) - 'A']);
			} 
			
			// 2. now가 연산자일때
			
			else {
				// 연산자가 나오면 스택에서 두 숫자를 꺼내 연산해주고, 연산한 값을 다시 스택에 넣는다.
				// 연산할 때애는 스택에서 두번째로 꺼낸 숫자가 앞에 와야 하기 때문에, first와 second로 변수명을 지정해주고 시작한다.
				double first = stack.pop();
				double second = stack.pop();
				
				switch (now) {
				
				case '*':
					double times = second * first;
					stack.push(times);
					break;
					
				case '+':
					double plus = second + first;
					stack.push(plus);
					break;
					
				case '/':
					double division = second / first;
					stack.push(division);
					break;
					
				case '-':
					double minus = second - first;
					stack.push(minus);
					break;
				}
			}
		}
		
		// 스택에 마지막 하나 남은 원소가 출력값이다.
		double result = stack.pop();
		// 소숫점 둘째 자리까지 출력한다.
		System.out.printf("%.2f", result);

	}
}