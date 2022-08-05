import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		while ((s = br.readLine()) != null) {

			int[] count = new int[4];

			for (int i = 0; i < s.length(); i++) {
				int c = s.charAt(i);

				// 소문자 개수 세기
				if (97 <= c && c <= 122) {
					count[0] += 1;
				}
				// 대문자 개수 세기
				if (65 <= c && c <= 90) {
					count[1] += 1;
				}
				// 숫자 개수 세기
				if (48 <= c && c <= 57) {
					count[2] += 1;
				}
				// 공백 개수 세기
				if (c == 32) {
					count[3] += 1;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			for (int i : count) {
				sb.append(i).append(" ");
			}
			
			System.out.println(sb);
		}
	}
}
