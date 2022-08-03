import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<s.length(); i++) {
			char now = s.charAt(i);
			
			switch (now) {
			
			case '+':
			case '-':
			case '*':
			case '/':
				// 스택이 비어있지 않고, stack.peek()의 우선순위가 더 높으면 먼저 꺼내준다.
				while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
					sb.append(stack.pop());
				}
				stack.push(now);
				break;
				
			case '(':
				stack.push(now);
				break;
				
			case ')':
				// 스택이 비어있지 않고, stack.peek()가 '('을 만나기 전까지 꺼내준다.
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				// '('은 출력하지 않고 그냥 꺼내준다.
				stack.pop();
				break;
				
			default :
				// 문자열은 바로 출력한다.
				sb.append(now);
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);

	}
	
	// 연산자의 우선순위
	public static int priority (char operator) {
		if(operator == '(' || operator == ')') {
			return 0;
		}
		else if (operator == '+' || operator == '-') {
			return 1;
		}
		else if (operator == '*' || operator == '/') {
			return 2;
		}
		return -1;
	}
}