import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수열의 원소를 배열에 저장
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		/*
		 * 스택이 비어있다면 원소의 "인덱스 값"을 스택에 넣어준다. 
		 * 스택이 비어있지 않다면 두 가지 경우의 수가 있다. 
		 * 
		 * 1. 현재 원소(=arr[i])가 스택 맨 위 값을 인덱스로 하는 원소(= arr[stack.peek()])보다 작은 경우 :현재 원소는 오큰수가 아니다.
		 * 2. 현재 원소(= arr[i])가 스택 맨 위 값을 인덱스로 하는 원소(= arr[stack.peek()])보다 큰 경우 : 현재 원소는 오큰수이다.
		 * 
		 * 1의 경우에는 스택에 그냥 넣어준다.
		 * 2의 경우에는 스택 맨 위 값을 인덱스로 하는 원소(= arr[stack.peek()])를 현재 원소의 값(= arr[i])으로 바꾸어준다.
		 */
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}

		// 스택에 남아있다는 것은 오큰수가 없다는 의미이므로 원소의 값을 -1로 바꾸어준다.
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

		// 오큰수 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append(' ');
		}
		System.out.println(sb);

		br.close();
	}
}
