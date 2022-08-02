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

		// 입력된 숫자를 담는 배열
		int[] nums = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 숫자의 등장 횟수를 담는 배열
		int[] nums_count = new int[1000001];
		for (int i = 0; i < N; i++) {
			nums_count[nums[i]] += 1;
		}

		// 오등큰수 구하기
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums_count[nums[stack.peek()]] < nums_count[nums[i]]) {
				nums[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		
		// 오등큰수가 없는 원소는 -1로 바꾸어주기
		while (!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}

		// 오등큰수 출력
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]).append(' ');
		}

		System.out.println(sb);
		br.close();
	}
}