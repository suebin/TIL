import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> leftStack = new Stack<>();
		Stack<Character> rightStack = new Stack<>();

		String start = br.readLine();
		// 스택에 초기 문자열 push
		for (int i = 0; i < start.length(); i++) {
			leftStack.push(start.charAt(i));
		}

		// 입력할 명령어의 개수
		int M = Integer.parseInt(br.readLine());

		// 명령어 실행
		for (int i = 0; i < M; i++) {
			String order = br.readLine();

			switch (order.charAt(0)) {
			case 'L':
				if (!leftStack.empty()) {
					rightStack.push(leftStack.pop());
				}
				break;
			case 'D':
				if (!rightStack.empty()) {
					leftStack.push(rightStack.pop());
				}
				break;
			case 'B':
				if (!leftStack.empty()) {
					leftStack.pop();
				}
				break;
			case 'P':
				leftStack.push(order.charAt(2));
				break;
			}

		}

		// 문자열 출력
		while (!leftStack.empty()) {
			rightStack.push(leftStack.pop());
		}

		StringBuilder sb = new StringBuilder();

		while (!rightStack.empty()) {
			sb.append(rightStack.pop());
		}
		System.out.println(sb);
		br.close();

	}
}