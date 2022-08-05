import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 알파벳 소문자로만 이루어진 단어
		String word =  br.readLine();
		
        // a-z의 개수를 구하기 위해 알파벳 개수(26)만큼 배열을 만든다.
        // word_count[0]은 a의 개수, word_count[26]은 z의 개수를 의미한다.
		int[] word_count = new int[26];
		

		for (int i=0; i<word.length(); i++) {
			char alphabet = word.charAt(i);
            // 해당하는 배열 인덱스를 찾아 1을 증가시킨다.
			word_count[alphabet-'a']++;
		}

		// 공백으로 구분해서 각 알파벳의 개수를 담은 배열을 출력
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<word_count.length; i++) {
			sb.append(word_count[i]).append(' ');
		}
		System.out.println(sb);
		br.close();
	}
}